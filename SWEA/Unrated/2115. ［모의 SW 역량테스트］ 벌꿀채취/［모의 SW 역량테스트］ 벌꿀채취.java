import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int n, m, c;
	static int[][] map;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // n*n
			m = Integer.parseInt(st.nextToken()); // 선택가능한 벌통의 개수
			c = Integer.parseInt(st.nextToken()); // 꿀의 최대양

			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 각 구간에서 얻을 수 있는 최대 수익
			int[][] profit = new int[n][n - m + 1]; // 이거 헷갈림

			for (int i = 0; i <= n - 1; i++) {
				for (int j = 0; j <= n - m; j++) {

					int arr[] = new int[m];
					int idx = 0;
					for (int x = i; x < i + 1; x++) {
						for (int y = j; y < j + m; y++) {
							arr[idx] = map[x][y];
							idx++;
						}

					}

					max = 0; // 초기화
					dfs(arr, 0, 0, 0);

					// 시작 좌표에 저장
					profit[i][j] = max;

				}

			}
			int answer = 0;

			// 1번 일꾼
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - m; j++) {

					// 2번 일꾼
					for (int x = 0; x < n; x++) {
						for (int y = 0; y <= n - m; y++) {
							// 같은 행에서 구간이 겹치면 제외
							if (i == x && Math.abs(j - y) < m) {
								continue;
							}
							int total = profit[i][j] + profit[x][y];
							answer = Math.max(answer, total);
						}
					}

				}
			}
			  sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

	private static void dfs(int[] arr, int idx, int sum, int profit) {

		if (idx == arr.length) {
			max = Math.max(max, profit);
			return;
		}

		// 벌통 선택
		if (sum + arr[idx] <= c) {
			dfs(arr, idx + 1, sum + arr[idx], profit + arr[idx] * arr[idx]);

		}

		dfs(arr, idx + 1, sum, profit);

	}

}