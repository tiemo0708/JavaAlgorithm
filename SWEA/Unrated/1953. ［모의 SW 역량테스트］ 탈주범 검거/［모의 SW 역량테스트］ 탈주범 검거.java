import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int n, m, r, c, l;
	static int[][] map;
	static boolean[][] visited;
	// 하, 상, 우, 좌
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken()); // 맨홀 X
			c = Integer.parseInt(st.nextToken());// 맨홀 Y
			l = Integer.parseInt(st.nextToken());// 소요시간
			map = new int[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = bfs(1, 1);
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int time, int cnt) {
		if (time == l) {
			return cnt;
		}

		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { r, c, time });
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			int cx = arr[0];
			int cy = arr[1];
			int t = arr[2];
			if (map[cx][cy] == 1) { // 상하좌우
				for (int i = 0; i < 4; i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || t >= l || visited[nx][ny])
						continue;

					if (i == 0 && !(map[nx][ny] == 1) && !(map[nx][ny] == 2) && !(map[nx][ny] == 4)
							&& !(map[nx][ny] == 7)) {// 하
						continue;
					} else if (i == 1 && !(map[nx][ny] == 1) && !(map[nx][ny] == 2) && !(map[nx][ny] == 5)
							&& !(map[nx][ny] == 6)) {// 상
						continue;
					} else if (i == 2 && !(map[nx][ny] == 1) && !(map[nx][ny] == 3) && !(map[nx][ny] == 6)
							&& !(map[nx][ny] == 7)) {// 우
						continue;
					} else if (i == 3 && !(map[nx][ny] == 1) && !(map[nx][ny] == 3) && !(map[nx][ny] == 4)
							&& !(map[nx][ny] == 5)) {// 좌
						continue;
					}
					cnt++;
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, t + 1 });
				}

			} else if (map[cx][cy] == 2) {// 상하
				for (int i = 0; i < 2; i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || t >= l || visited[nx][ny])
						continue;
					if (i == 0 && !(map[nx][ny] == 1) && !(map[nx][ny] == 2) && !(map[nx][ny] == 4)
							&& !(map[nx][ny] == 7)) {// 하
						continue;
					} else if (i == 1 && !(map[nx][ny] == 1) && !(map[nx][ny] == 2) && !(map[nx][ny] == 5)
							&& !(map[nx][ny] == 6)) {// 상
						continue;
					}
					cnt++;
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, t + 1 });
				}

			} else if (map[cx][cy] == 3) { // 좌우
				for (int i = 2; i < 4; i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || t >= l || visited[nx][ny])
						continue;
					if (i == 2 && !(map[nx][ny] == 1) && !(map[nx][ny] == 3) && !(map[nx][ny] == 6)
							&& !(map[nx][ny] == 7)) {// 우
						continue;
					} else if (i == 3 && !(map[nx][ny] == 1) && !(map[nx][ny] == 3) && !(map[nx][ny] == 4)
							&& !(map[nx][ny] == 5)) {// 좌
						continue;
					}
					cnt++;
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, t + 1 });
				}

			} else if (map[cx][cy] == 4) { // 상우
				for (int i = 1; i < 3; i++) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || t >= l || visited[nx][ny])
						continue;
					if (i == 1 && !(map[nx][ny] == 1) && !(map[nx][ny] == 2) && !(map[nx][ny] == 5)
							&& !(map[nx][ny] == 6)) {// 상
						continue;
					} else if (i == 2 && !(map[nx][ny] == 1) && !(map[nx][ny] == 3) && !(map[nx][ny] == 6)
							&& !(map[nx][ny] == 7)) {// 우
						continue;
					}
					cnt++;
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, t + 1 });
				}

			} else if (map[cx][cy] == 5) { // 0,2 하우
				for (int i = 0; i < 4; i += 2) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || t >= l || visited[nx][ny])
						continue;
					if (i == 0 && !(map[nx][ny] == 1) && !(map[nx][ny] == 2) && !(map[nx][ny] == 4)
							&& !(map[nx][ny] == 7)) {// 하
						continue;
					} else if (i == 2 && !(map[nx][ny] == 1) && !(map[nx][ny] == 3) && !(map[nx][ny] == 6)
							&& !(map[nx][ny] == 7)) {// 우
						continue;
					}
					cnt++;
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, t + 1 });
				}

			} else if (map[cx][cy] == 6) {// 0,3 하좌
				for (int i = 0; i < 4; i += 3) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || t >= l || visited[nx][ny])
						continue;

					if (i == 0 && !(map[nx][ny] == 1) && !(map[nx][ny] == 2) && !(map[nx][ny] == 4)
							&& !(map[nx][ny] == 7)) {// 하
						continue;
					} else if (i == 3 && !(map[nx][ny] == 1) && !(map[nx][ny] == 3) && !(map[nx][ny] == 4)
							&& !(map[nx][ny] == 5)) {// 좌
						continue;
					}
					cnt++;
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, t + 1 });
				}

			} else if (map[cx][cy] == 7) {// 1,3 싱좌
				for (int i = 1; i < 4; i += 2) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || t >= l || visited[nx][ny])
						continue;
					if (i == 1 && !(map[nx][ny] == 1) && !(map[nx][ny] == 2) && !(map[nx][ny] == 5)
							&& !(map[nx][ny] == 6)) {// 상
						continue;
					} else if (i == 3 && !(map[nx][ny] == 1) && !(map[nx][ny] == 3) && !(map[nx][ny] == 4)
							&& !(map[nx][ny] == 5)) {// 좌
						continue;
					}
					cnt++;
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, t + 1 });
				}
			}

		}

		return cnt;

	}

}
