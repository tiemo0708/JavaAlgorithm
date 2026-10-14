import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int d, w, k;
	static int arr[][];
	static int[] treatment; // 약품기록
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken()); // 두께(세로)
			w = Integer.parseInt(st.nextToken()); // 가로
			k = Integer.parseInt(st.nextToken()); // 합격기준

			answer = Integer.MAX_VALUE;
			arr = new int[d][w];
			treatment = new int[d];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					;
				}
			}

			dfs(0, 0);// 지금 행, 약품 사용횟수
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int row, int used) {

		if (answer < used) {
			return;
		}

		if (row == d) {
			if (check()) {
				answer = Math.min(answer, used);
			}
			return;
		}

		// 약품 X
		treatment[row] = -1;
		dfs(row + 1, used);

		// 약품 A
		treatment[row] = 0;
		dfs(row + 1, used + 1);

		// 약품 B
		treatment[row] = 1;
		dfs(row + 1, used + 1);
	}

	private static boolean check() {
		for (int c = 0; c < w; c++) {
			int prev = -1; // 전값
			int count = 0;
			boolean passed = false;

			for (int r = 0; r < d; r++) {
				// 약품 안넣으면 원본값, 약품 넣으면 해당 약품값
				int current = treatment[r] == -1 ? arr[r][c] : treatment[r];
				if (current == prev) {
					count++;
				} else {
					count = 1;
				}
				prev = current;

				if (count >= k) {
					passed = true;
					break;
				}
			}

			if (!passed) {
				return false;
			}

		}

		return true;
	}

}
