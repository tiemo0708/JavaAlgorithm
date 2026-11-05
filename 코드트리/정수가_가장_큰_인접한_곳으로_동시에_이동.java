package 코드트리;

import java.util.*;

// 모든 구슬 이동 → 도착 개수 집계 → 충돌한 구슬 제거
// 코드트리 제출 시 package 선언을 제거하고 클래스명을 Main으로 변경한다.
public class 정수가_가장_큰_인접한_곳으로_동시에_이동 {
    static int n, m, t;
    static int[][] grid;
    static int[][] marbles;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        marbles = new int[m][2];
        for (int i = 0; i < m; i++) {
            // 입력 좌표 1~n을 배열 인덱스 0~n-1로 변환
            marbles[i][0] = sc.nextInt() - 1;
            marbles[i][1] = sc.nextInt() - 1;
        }

        for (int time = 0; time < t; time++) {
            int[][] temp = new int[n][n];

            // 살아 있는 모든 구슬을 먼저 이동시킨다.
            for (int i = 0; i < m; i++) {
                if (marbles[i][0] == -1) continue;

                int cx = marbles[i][0];
                int cy = marbles[i][1];
                int max = 0;
                int rx = -1;
                int ry = -1;

                // 상 → 하 → 좌 → 우 순서로 확인한다.
                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                    // 같은 값이면 먼저 선택한 방향을 유지한다.
                    if (grid[nx][ny] > max) {
                        max = grid[nx][ny];
                        rx = nx;
                        ry = ny;
                    }
                }

                marbles[i][0] = rx;
                marbles[i][1] = ry;
                temp[rx][ry]++;
            }

            // 이동이 모두 끝난 뒤 같은 칸에 도착한 구슬을 전부 제거한다.
            for (int i = 0; i < m; i++) {
                if (marbles[i][0] == -1) continue;

                int cx = marbles[i][0];
                int cy = marbles[i][1];
                if (temp[cx][cy] >= 2) {
                    marbles[i][0] = -1;
                    marbles[i][1] = -1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (marbles[i][0] != -1) answer++;
        }
        System.out.println(answer);
    }
}
