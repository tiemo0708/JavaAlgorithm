import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

	static int[][] arr;
	static boolean[][] visited;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int n;
	static int ex, ey;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			n = Integer.parseInt(br.readLine());

			arr = new int[n][n];
			visited = new boolean[n][n];

			// 맵 입력
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 시작 위치
			StringTokenizer st = new StringTokenizer(br.readLine());

			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());

			// 도착 위치
			st = new StringTokenizer(br.readLine());

			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());

			int answer = bfs(sx, sy);

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

	static int bfs(int sx, int sy) {

		Queue<int[]> queue = new ArrayDeque<>();

		// x, y, 현재 시간
		queue.offer(new int[] { sx, sy, 0 });

		visited[sx][sy] = true;

		while (!queue.isEmpty()) {

			int[] cur = queue.poll();

			int cx = cur[0];
			int cy = cur[1];
			int time = cur[2];

			// 목적지 도착
			if (cx == ex && cy == ey) {
				return time;
			}

			// 소용돌이 때문에 현재 위치에서 기다려야 하는지

			for (int d = 0; d < 4; d++) {

				int nx = cx + dx[d];
				int ny = cy + dy[d];

				// 범위 밖
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}

				// 장애물, 이미 방문
				if (arr[nx][ny] == 1 || visited[nx][ny]) {
					continue;
				}

				// 일반 바다
				if (arr[nx][ny] == 0) {
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, time + 1 });
				}

				// 소용돌이
				else if (arr[nx][ny] == 2) {
					// time % 3 == 2 이면 이동 가능
					if (time % 3 == 2) {
						visited[nx][ny] = true;
						queue.offer(new int[] { nx, ny, time + 1 });

					} else {
						// 기다려야하면 시간만 +1
						queue.offer(new int[] { cx, cy, time + 1 });
					}
				}
			}

		

		}

		// 목적지까지 갈 수 없음
		return -1;
	}
}