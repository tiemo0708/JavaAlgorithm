package src.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2839_설탕배달 {
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        solve(n, 0);
        System.out.println(result);
    }

    private static void solve(int remain, int count) {
        if (remain < 0) return;
        if (remain == 0) {
            if (result == -1 || count < result) {
                result = count;
            }
            return;
        }
        solve(remain - 5, count + 1);
        solve(remain - 3, count + 1);
    }
}