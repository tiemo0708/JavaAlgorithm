package src.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1206_View {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sum = 0;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] ar = new int[n];
            for (int i = 0; i<n; i++){
                ar[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=2; i<=n-3; i++){
                int a = ar[i-2];
                int b = ar[i-1];
                int c = ar[i+1];
                int d = ar[i+2];
                int max = Math.max(a,Math.max(b, Math.max(c,d)));

                if(ar[i]>max){
                    sum += ar[i] - max;
                }
            }
            sb.append("#").append(test_case).append(" ").append(sum).append('\n');
        }
        System.out.print(sb.toString());
    }
}
