import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int ex, ey;
	static int n;
	static int[][] arr;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey =Integer.parseInt(st.nextToken());
			visited = new boolean[n];
			arr = new int[n][2];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			dfs(sx, sy, 0, 0); // 현재 x, 현재 y, 거리합, 방문집
			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cx, int cy, int dist, int cnt) {
		if (min < dist) {
			return;
		}

		if (cnt == n) {
			int ed = Math.abs(cx - ex) + Math.abs(cy - ey);
			min = Math.min(dist + ed, min);
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int nx = arr[i][0];
				int ny = arr[i][1];
				int nd = Math.abs(cx - nx) + Math.abs(cy - ny);
				dfs(nx, ny, dist + nd, cnt + 1);
				visited[i] = false;
			}
		}

	}

}
