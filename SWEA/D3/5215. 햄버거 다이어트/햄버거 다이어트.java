import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int l;
	static int max;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 재료의 수
			l = Integer.parseInt(st.nextToken()); // 제한 칼로리

			arr = new int[2][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[0][i] = Integer.parseInt(st.nextToken()); // 맛점수
				arr[1][i] = Integer.parseInt(st.nextToken()); // 칼로리

			}
			max = 0;
			dfs(0, 0, 0); // start, 맛누적, 칼로리 누적
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int start, int t, int k) {
		max = Math.max(max, t);

		for (int i = start; i < n; i++) {
			int a = arr[0][i]; // 맛
			int b = arr[1][i]; // 칼로리

			if (k + b <= l) {
				dfs( i+1, t + a, k + b);
			}
		}

	}

}
