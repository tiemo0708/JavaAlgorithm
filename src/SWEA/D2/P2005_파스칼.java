package src.SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2005_파스칼 {
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n =  Integer.parseInt(br.readLine());
            int[][] dp = new int[n][n];
            for (int i =0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    }
                }
            }
                sb.append("#").append(T).append("\n");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j <= i; j++) {
                        sb.append(dp[i][j]);
                        if (j != i) sb.append(" ");
                    }
                    sb.append("\n");
                }
            }

            System.out.print(sb);
        }
    }

