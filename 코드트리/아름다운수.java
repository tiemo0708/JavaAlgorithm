package 코드트리;

import java.util.*;

public class 아름다운수 {
    static int n;
    static int r = 0;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dfs(0);
        System.out.println(r);
    }

    static void dfs(int d) {
        if (d == n) {
            if (check()) r++;
            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr.add(i);
            dfs(d + 1);
            arr.remove(arr.size() - 1);
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i += arr.get(i)) {
            int tar = arr.get(i);
            if (i + tar > n) return false;

            for (int j = i; j < i + tar; j++) {
                if (arr.get(j) != tar) return false;
            }
        }
        return true;
    }
}