package src.programus;

import java.util.*;

public class 게임_맵_최단거리 {

    public static void main(String[] args) {
        // 예시 테스트 케이스
        int[][] maps1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int[][] maps2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };


        System.out.println(solution(maps1)); // 예상 출력: 11
        System.out.println(solution(maps2)); // 예상 출력: -1
    }

    static class Point{
        int r;
        int c;
        int dist;
        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static int solution(int[][] maps) {
        int n = maps.length; //행 길이
        int m = maps[0].length; //열 길이
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new ArrayDeque<>();
        visited[0][0] = true;
        queue.add(new Point(0, 0, 1));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int k = 0; k < 4; k++){
                int nr = cur.r + dx[k];
                int nc = cur.c + dy[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr][nc] == 0) continue;

                // 도착 점 도달 체크 위치
                if (nr == n - 1 && nc == m - 1) {
                    return cur.dist + 1;
                }

                visited[nr][nc] = true;
                queue.add(new Point(nr, nc, cur.dist + 1));
            }
        }
        return -1;
    }
}