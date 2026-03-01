package src.기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멋쟁이숫자 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solution(s));
    }

    static int solution(String s) {
        int max = -1;

        for (int i = 0; i <= s.length() - 3; i++) {
            String sub = s.substring(i, i + 3);

            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(1) == sub.charAt(2)) {
                int num = Integer.parseInt(sub);
                if (num > max) {
                    max = num;
                }
            }
        }

        return max;
    }
}
