package src.탐색.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P27211_도넛행성 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        // 여기에 풀이 작성
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j]==0) {
                    visited[i][j] = true;
                    bfs(i,j);
                    answer++;
                }

            }
        }


        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int cur[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = (cur[0] + dx[i] + N) % N;
                int ny = (cur[1] + dy[i] + M) % M;

                if(!visited[nx][ny]&& map[nx][ny]==0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }

        }
    }
}