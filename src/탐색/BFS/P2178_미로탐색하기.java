package src.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색하기 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0}; // 오른쪽, 아래, 왼쪽, 위
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); //101010101
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) { //BFS 탐색할 수 없을때까지 돌림
            int[] now = queue.poll();

            for (int k = 0; k < 4; k++) { //상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && y>=0 && x < N && y< M){ //배열을 넘어가면 안됌
                    if(A[x][y]!=0&&!visited[x][y]){ //0이나 기방문한곳 안됌
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; //핵심
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }
}
