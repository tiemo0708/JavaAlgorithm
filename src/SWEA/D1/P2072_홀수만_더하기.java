package src.SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2072_홀수만_더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0; i<10; i++){
                int N = Integer.parseInt(st.nextToken());
                if(N%2!=0){
                    sum +=N;
                }
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}
