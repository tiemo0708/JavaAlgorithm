package src.SWEA.D2;

import java.util.*;
import java.io.*;

public class P1926_간단한_369 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i =1; i <=N; i++){
            String num = Integer.toString(i);
            String clap = "";
            for(int j = 0; j < num.length(); j++){
                char c = num.charAt(j);
                if (c == '3' || c == '6' || c == '9') {
                    clap += "-";
                }
            }

            if (clap.length() > 0) {
                sb.append(clap);
            } else {
                sb.append(num);
            }

            sb.append(" ");
        }

        System.out.println(sb);
    }
}
