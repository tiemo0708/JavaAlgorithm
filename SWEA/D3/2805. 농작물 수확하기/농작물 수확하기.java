
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j)-'0';
				}
			}
			
			int c = n/2;
			int sum =0;
			for(int i =0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int distanc = Math.abs(c-i) + Math.abs(c-j);
					if(distanc <= c) {
						sum += arr[i][j];
					}
					
				}
			}
			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		}
			System.out.println(sb);
	}

}
