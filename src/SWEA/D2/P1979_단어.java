package src.SWEA.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1979_단어 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int result = 0;

            int[][] m = new int[n][n];

            for (int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j<n; j++){
                    m[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i<n; i++){
                int count = 0;
                for (int j = 0; j<n; j++){
                    if(m[j][i] == 1){
                        count ++;
                    }
                    if (m[j][i] ==0){
                        if(count == k)
                        {
                            result ++;
                        }
                        count = 0;
                    }
                    if (j == n-1){
                        if(count == k)
                        {
                            result ++;
                        }
                    }
                }
            }

            for (int i = 0; i<n; i++){
                int count = 0;
                for (int j = 0; j<n; j++){
                    if(m[i][j] == 1){
                        count ++;
                    }
                    if (m[i][j] ==0){
                        if(count == k)
                        {
                            result ++;
                        }
                        count = 0;
                    }
                    if (j == n-1){
                        if(count == k)
                        {
                            result ++;
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(' ').append(result).append('\n');
        }
        System.out.println(sb);
    }
}
