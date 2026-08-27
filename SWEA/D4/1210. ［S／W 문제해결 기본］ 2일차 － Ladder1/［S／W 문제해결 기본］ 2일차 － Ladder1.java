import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	// 왼, 오, 위
	static int[] dx = { 0, 0, -1 };
	static int[] dy = { -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int tn = Integer.parseInt(br.readLine());

			int[][] arr = new int[100][100];
			int endX = 0;
			int endY = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {// 도착지
						endX = i;
						endY = j;
					}
				}
			}
			int result = bfs(endX, endY, arr);
			sb.append("#").append(tn).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

	private static int bfs(int sx, int sy, int[][] arr) {

		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sx, sy });
		// 좌우 확인후 없으면 위로 한칸, 지나온 칸은 0으로
		// 갈곳이 없으면 그때의 y좌표

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (now[0] == 0) {
				return now[1];
			}
			boolean up = true;
			for (int i = 0; i < 2; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (ny >= 0 && ny < 100 && arr[nx][ny] == 1) {
					queue.add(new int[] { nx, ny });
					arr[nx][ny] = -1; // 재탐색 못하게
					up = false;
					break;
				}
			}
			if (up) {
				up = true;
				int nx = now[0] + dx[2];
				int ny = now[1] + dy[2];
				if (nx >= 0 && arr[nx][ny] == 1) {
					queue.add(new int[] { nx, ny });
					arr[nx][ny] = -1;
				}
			}
		}
		return -1;
	}

}
