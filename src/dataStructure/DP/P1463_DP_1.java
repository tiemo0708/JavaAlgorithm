package src.dataStructure.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463_DP_1 {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1]; // 숫자와 인덱스를 1:1로 대응시키기 위해서
        dp[0] = dp[1] = 0;

        System.out.print(recur(N));

    }

    private static int recur(int N) {
        if (dp[N] == null) { // 1 이 될때까지
            // 6으로 나눠지는 경우
            if(N % 6 == 0){
                dp[N] = Math.min(recur(N-1), Math.min(recur(N/3), recur(N/2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0){
                dp[N] = Math.min(recur(N/3), recur(N-1))+1;
            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0){
                dp[N] = Math.min(recur(N/2), recur(N-1))+1;
            }
            // 2와 3으로 나눠지는 경우
            else {
                dp[N] = recur(N-1)+1;
            }
        }
        return dp[N];
    }
}
