package src.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1979_단어퍼즐 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[n][n];

            int sum =0;

            for (int i =0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j =0; j<n; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i =0; i<n; i++) {
                int s =0;
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j]==1){
                        s++;
                    }
                    if(s == k && (matrix[i][j] ==0 || j == n-1)){
                        sum++;
                    }
                    if(matrix[i][j]==0){
                        s = 0;
                    }
                }
            }
            for (int j =0; j<n; j++) {
                int s = 0;
                for (int i = 0; i < n; i++) {
                    if(matrix[i][j]==1){
                        s++;
                    }
                    if(s == k && (matrix[i][j] ==0 || i == n-1)){
                        sum++;
                    }
                    if(matrix[i][j]==0){
                        s = 0;
                    }

                }
            }
            sb.append("#").append(tc).append(" "). append(sum).append('\n');
        }
        System.out.print(sb.toString());
    }
}
