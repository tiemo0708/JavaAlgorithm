import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int r, c;
	static char[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static HashSet<Character> visited;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new char[r][c];

			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				for (int j = 0; j < c; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			visited = new HashSet<>();
			int cnt = 1;
			max = cnt;
			visited.add(arr[0][0]);
			dfs(0, 0, cnt);
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int cnt) {
		if (max < cnt) {
			max = cnt;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= r || ny >= c)
				continue;
			else if (visited.add(arr[nx][ny])) {
				dfs(nx, ny, cnt + 1);
				visited.remove(arr[nx][ny]);
			}
		}
	}

}
