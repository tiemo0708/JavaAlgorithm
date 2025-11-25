package src.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1204_최빈수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T= Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++) {
            br.readLine();

            int [] count = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i<1000; i++){
                int score = Integer.parseInt(st.nextToken());
                count[score]++;
            }

            int max = 0;
            int answer = 0;

            for(int i =100; i>=0; i--){
                if(count[i]>max){
                    max = count[i];
                    answer = i;
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer).append('\n');
        }
        System.out.print(sb.toString());
    }
}
