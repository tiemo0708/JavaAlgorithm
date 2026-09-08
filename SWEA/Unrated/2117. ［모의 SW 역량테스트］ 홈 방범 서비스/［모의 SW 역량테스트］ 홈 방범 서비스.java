
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()); //지불비용

			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = 0;

			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) { // 중심 후보

					for (int k = 1; k <= 2 * n - 1; k++) { // 범위 후보
						int count = 0; // 이번 범위에 들어오는 집 개수

						for (int i = 0; i < n; i++) {
							for (int j = 0; j < n; j++) { // 전체 범위 조사
								int distance = Math.abs(x - i) + Math.abs(y - j);// 맨해튼 거리
								if (distance <= k - 1 && arr[i][j] == 1) {
									count++;
								}
							}
						}
						int cost =  k * k + (k - 1) * (k - 1);
						if(cost<=count*m) {
							answer = Math.max(answer, count);
						}
					}

				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);

	}

}
