package src.탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14503_로봇청소기 {
    static int[] dx = {-1,  0,   1,  0};
    static int[] dy = { 0,  1,   0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        map[r][c] = 2;
        cnt++;
        while(true) {
            boolean hasUnclean = false;
            for(int k = 0; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];
                if (map[nr][nc] == 0) {
                    hasUnclean = true;
                    break;

                }
            }
            if (!hasUnclean) {
                int backR = r + dx[(d + 2) % 4];
                int backC = c + dy[(d + 2) % 4];
                if(map[backR][backC] != 1){
                    r = backR;
                    c = backC;
                }
                else{
                    break;
                }

            } else {
                d = (d + 3) % 4;
                int nr = r + dx[d];
                int nc = c + dy[d];
                if (map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    map[r][c] = 2;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
