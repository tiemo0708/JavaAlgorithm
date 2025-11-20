package src.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P1954_달팽이숫자 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] map = new int[N][N];

            // 방향: 오른쪽, 아래, 왼쪽, 위
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            int x = 0, y = 0;   // 현재 위치
            int dir = 0;        // 현재 방향 인덱스 (0~3) 오른쪽 부터 시작
            int num = 1;        // 채울 숫자
            for (int k = 1; k <= N * N; k++) {
                map[x][y] = num++;
                // 다음 위치 계산
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0) {
                    dir = (dir + 1) % 4; // 회전
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx;
                y = ny;
            }
            sb.append("#").append(test_case).append('\n');
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(map[i][j]);
                    if (j < N - 1) sb.append(' ');
                }
                sb.append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
