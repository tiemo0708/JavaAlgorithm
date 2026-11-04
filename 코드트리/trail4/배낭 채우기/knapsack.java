import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //보석 개수
        int m = sc.nextInt(); // 넘으면 안되는 무게의합
        int[] weight = new int[n]; //무게
        int[] value = new int[n]; //가치
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1]; // 배낭 용량이 i 일때 넘으면 안되는
     
        for (int i = 0; i < n; i++) { // 보석 하나 선택
            for (int w = m; w >= weight[i]; w--) { // 그 보석으로 용량별 계산
                dp[w] = Math.max(dp[w],dp[w-weight[i]]+value[i]);
            }

        }
        System.out.println(dp[m]);
    }
}
