
import java.util.*;
import java.io.*;

public class Solution {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            int maxH = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, arr[i]);
            }

            int cnt1 = 0;
            int cnt2 = 0;

            for (int i = 0; i < N; i++) {
                int diff = maxH - arr[i];

                if (diff == 0) continue;

                cnt1 += diff % 2;
                cnt2 += diff / 2;
            }

            // +2 한 번을 +1 두 번으로 분해
            while (cnt2 - cnt1 > 1) {
                cnt2--;
                cnt1 += 2;
            }

            int ans = 0;

            if (cnt1 > cnt2) {
                ans = cnt1 * 2 - 1;
            } else if (cnt2 > cnt1) {
                ans = cnt2 * 2;
            } else {
                ans = cnt1 + cnt2;
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
