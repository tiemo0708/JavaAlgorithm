package src.SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2001_파리퇴치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 1-based index를 쓰기 위해 N+1 x N+1 배열 사용
            int[][] ps = new int[N + 1][N + 1];  // prefix sum 배열

            // 격자 입력 + 동시에 2차원 누적합 계산
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    int val = Integer.parseInt(st.nextToken());

                    // 2D prefix sum: ps[i][j]
                    ps[i][j] = val
                            + ps[i - 1][j]
                            + ps[i][j - 1]
                            - ps[i - 1][j - 1];
                }
            }

            int max = 0;

            // 파리채의 왼쪽 위 좌표 (i, j)를 전부 시도
            for (int i = 1; i <= N - M + 1; i++) {
                for (int j = 1; j <= N - M + 1; j++) {
                    int x1 = i;
                    int y1 = j;
                    int x2 = i + M - 1;
                    int y2 = j + M - 1;

                    // (x1, y1) ~ (x2, y2) 사각형 합
                    int sum = ps[x2][y2]
                            - ps[x1 - 1][y2]
                            - ps[x2][y1 - 1]
                            + ps[x1 - 1][y1 - 1];

                    if (sum > max) {
                        max = sum;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append('\n');
        }

        System.out.print(sb.toString());
    }
}
