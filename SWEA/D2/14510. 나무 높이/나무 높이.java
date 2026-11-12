import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine().trim());

            int[] trees = new int[n];
            int maxHeight = 0;

            StringTokenizer st =
                new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
            }

            int one = 0;
            int two = 0;

            for (int i = 0; i < n; i++) {
                int diff = maxHeight - trees[i];

                one += diff % 2;
                two += diff / 2;
            }

            while (two > one + 1) { // 빈홀수날이 1개 이하로 만들기
                two--;
                one += 2;
            }

            int answer = Math.max(one * 2 - 1, two * 2);// 더긴 날로

            sb.append('#').append(tc).append(' ')
              .append(answer).append('\n');
        }

        System.out.print(sb);
    }
}