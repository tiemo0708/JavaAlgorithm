package 코드트리;

import java.util.*;

public class 마을구분하기 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int count;
    static List<Integer> rank = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // Please write your code here.
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j]==1){ // 사람일때만
                    grid[i][j] = -1; //방문체크
                    count =1;
                    dfs(i, j, grid); //x,y,배열, count
                    rank.add(count);
                }
            }
        }
        Collections.sort(rank);
        System.out.println(rank.size());
        for(int r:rank){
            System.out.println(r);
        }

    }

    private static void dfs(int x, int y, int[][] grid){

        for(int i=0; i<4; i++){
            int nx = x +dx[i];
            int ny = y +dy[i];
            if(nx>=0 && ny>=0 && nx<grid.length && ny<grid.length && grid[nx][ny] == 1){
                grid[nx][ny] = -1;
                count++;
                dfs(nx, ny, grid);

            }
        }


    }
}