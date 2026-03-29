package src.탐색.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1062_가르침 {
    static boolean[] learned = new boolean[26];
    static String[] words;
    static int N, K;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }

        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        backtrack(0, 0);
        System.out.println(result);
    }


    static void backtrack(int depth, int start) {
        if (depth == K - 5) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean canRead = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!learned[words[i].charAt(j) - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) count++;
            }
            result = Math.max(result, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                backtrack(depth + 1, i + 1);
                learned[i] = false;
            }
        }
    }
}