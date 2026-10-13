import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 도시 크기
			int m = Integer.parseInt(st.nextToken()); // 지불 비용

			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {

					for (int k = 1; k <= 2 * n - 1; k++) {
						int count =0;
						for(int i =0; i<n; i++) {
							for(int j=0; j<n; j++) {
								if(k-1>=Math.abs(x-i)+Math.abs(y-j) && arr[i][j]==1) {
									count++;
								}
								
							}
						}
						if(k*k+(k-1)*(k-1)<=count*m) {
							result = Math.max(result, count);
						}
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
        System.out.println(sb);
	}

}
