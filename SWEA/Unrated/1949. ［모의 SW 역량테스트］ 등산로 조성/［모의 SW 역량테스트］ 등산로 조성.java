import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, k;
	static int[][] arr;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n][n];

			int maxValue = 0;
			int maxCnt = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					if (maxValue < arr[i][j]) {
						maxValue = arr[i][j];
						maxCnt = 1;
					} else if (maxValue == arr[i][j]) {
						maxCnt++;
					}
				}
			}

			int[][] maxMs = new int[maxCnt][2]; // 최고점산 좌표
			int idx = 0;
			end: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == maxValue) {
						maxMs[idx][0] = i;
						maxMs[idx][1] = j;
						idx++;
						if (idx == maxCnt) {
							break end;
						}
					}
				}
			}
			result = 0;
			for (int i = 0; i < maxCnt; i++) {
				visited = new boolean[n][n];
				int x = maxMs[i][0];
				int y = maxMs[i][1];

				visited[x][y] = true;
				dfs(x, y, 1, true, arr[x][y]);// x,y,길이,공사 여부, 산 높이
			}
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cx, int cy, int cnt, boolean b, int h) {

		result = Math.max(cnt, result);

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny])
				continue;
			if (h > arr[nx][ny]) {// 산안깍아도 될때
				visited[nx][ny] = true;
				dfs(nx, ny, cnt + 1, b, arr[nx][ny]);
				visited[nx][ny] = false;
			} else if (arr[nx][ny] - h + 1 <= k && b) { // 산깍기
				int temp = arr[nx][ny];
				arr[nx][ny] = h - 1;
				visited[nx][ny] = true;
				dfs(nx, ny, cnt + 1, false, arr[nx][ny]);
				visited[nx][ny] = false;
				arr[nx][ny] = temp;
			}

		}

	}

}
