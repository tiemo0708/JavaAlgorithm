package src.SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1859_백만장자_복습 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] prices = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            long profit = 0L;
            int max = 0;

            for(int i = N-1; i >= 0; i--){
                if(prices[i]> max){
                    max = prices[i];
                }else{
                    profit += max -  prices[i];
                }
            }


            // TODO: 뒤에서부터 순회하면서 미래 최고가를 갱신하고 최대 이익을 계산하기

            sb.append("#").append(test_case).append(" ").append(profit).append('\n');
        }

        System.out.print(sb);
    }
}
