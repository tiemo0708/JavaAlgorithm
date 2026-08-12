import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;
	static int[][] arr;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			visited = new boolean[16][16];
			arr = new int[16][16];
			result = 0;
			int test_num = Integer.parseInt(br.readLine());
			int[] start = new int[2];
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					arr[i][j] = str.charAt(j) - '0';
					if (arr[i][j] == 2) {
						start[0] = i;
						start[1] = j;
					}
				}
			}
			bfs(start[0], start[1]);
			sb.append("#").append(test_num).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[i][j] = true;
		queue.offer(new int[] { i, j });

		while (!queue.isEmpty()) {
			int[] now = queue.poll(); // 현재의 x, y
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if (x >= 0 && x < 16 && y >= 0 && y < 16 && arr[x][y] != 1 && !visited[x][y]) {
					visited[x][y] = true;
					queue.offer(new int[] { x, y });
					if (arr[x][y] == 3) {
						result = 1;
						break;
					}
				}
			}
		}

	}
}
