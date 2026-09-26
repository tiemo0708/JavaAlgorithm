package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class J1695_단지번호붙이기 {
    static int n;
    static int[][] arr;
    static int cnt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int house;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i =0; i<n; i++) {
            String str = br.readLine();
            for(int j =0; j<n; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        cnt = 1;
        List<Integer> houseRank = new ArrayList<>();
        for(int i =0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j]==1) {
                    house = 0;
                    cnt++;
                    arr[i][j] = cnt;
                    dfs(i,j);
                    houseRank.add(house);
                }

            }
        }
        Collections.sort(houseRank);
        System.out.println(cnt-1);
        for(int h : houseRank) {
            System.out.println(h);
        }
    }
    private static void dfs(int x, int y) {
        house++;
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || ny <0|| nx>=n || ny>=n || arr[nx][ny]!=1) continue;
            arr[nx][ny] = cnt;
            dfs(nx,ny);
        }
    }
}
