package SWEA.D2.P2005_파스칼의삼각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class Solution {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            sb.append("#").append(test_case).append("\n");

            for(int i = 0; i<n; i++) {
                for(int j=0; j<=i; j++) {
                    if(i-1 <0 || j-1 <0) {
                        arr[i][j] = 1;
                    }else {
                        arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                    }
                }

            }
            for(int i= 0; i<n; i++) {
                for(int j=0; j<=i; j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }


        }
        System.out.println(sb);
    }
}
