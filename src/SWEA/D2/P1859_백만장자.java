package src.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1859_백만장자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());

            int[] prices = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            long profit = 0L;
            int maxPrice = 0;

            // 뒤에서부터 최대값 갱신하면서 이익 계산
            for (int i = N - 1; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i];      // 새로운 최고가(팔 날)
                } else {
                    profit += (maxPrice - prices[i]); // 오늘 사서 나중에 maxPrice에 판다고 가정
                }
            }

            sb.append("#").append(test_case).append(" ").append(profit).append('\n');
        }

        System.out.print(sb.toString());
    }
}
