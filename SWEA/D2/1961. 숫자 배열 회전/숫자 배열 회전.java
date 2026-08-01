
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int[][] s_90 = new int[n][n];
			int[][] s_180 = new int[n][n];
			int[][] s_270 = new int[n][n];
			
			for(int i =0 ; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j =0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 90
			for(int i =n-1; i>=0; i--) {
				for(int j=0; j<n; j++) {
					s_90[j][i] = arr[Math.abs(i-n+1)][j];
				}
			}
			
			// 180
			for(int i =n-1; i>=0; i--) {
				for(int j=0; j<n; j++) {
					s_180[j][i] = s_90[Math.abs(i-n+1)][j];
				}
			}
			
			// 270
			for(int i =n-1; i>=0; i--) {
				for(int j=0; j<n; j++) {
					s_270[j][i] = s_180[Math.abs(i-n+1)][j];
				}
			}
			
			sb.append("#").append(test_case).append("\n");
			for(int i =0 ; i<n; i++) {
				for(int j =0; j<n; j++) {
					sb.append(s_90[i][j]);
				}
				sb.append(" ");
				for(int j =0; j<n; j++) {
					sb.append(s_180[i][j]);
				}
				sb.append(" ");
				for(int j =0; j<n; j++) {
					sb.append(s_270[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
