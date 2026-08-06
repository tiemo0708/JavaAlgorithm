import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int result=0;
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			 //열에서 n(1) s(2) 페어 찾기, 위에서 아래로 
			for(int i=0; i<n; i++) {
				boolean isN = false;
				for(int j=0; j<n; j++) {
					if(arr[j][i] ==1) {
						isN =true;
						continue;
					} else if(isN && arr[j][i] == 2) {
						result++;
						isN=false;
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
