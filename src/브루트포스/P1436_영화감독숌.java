package src.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1436_영화감독숌 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int count = 0;
        int num = 666;

        while (true) {
            if (String.valueOf(num).contains("666")) {
                count++;
                if (count == n) {
                    System.out.println(num);
                    break;
                }
            }
            num++;
        }
    }
}