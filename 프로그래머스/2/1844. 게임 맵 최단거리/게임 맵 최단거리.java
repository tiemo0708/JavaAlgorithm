import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int rows;
	static int cols;

	public static int solution(int[][] maps) {
		rows = maps.length;
		cols = maps[0].length;
		
		map = maps;
		int answer = 2;

		answer = bfs(0, 0, answer);
		return answer;
	}

	private static int bfs(int x, int y, int answer) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { x, y });
		map[x][y] = answer;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && map[nx][ny] == 1) {
					map[nx][ny] = map[now[0]][now[1]]+1;
					if (nx == rows - 1 && ny == cols - 1) {
						return map[nx][ny]-1;
					}
					queue.offer(new int[] { nx, ny });
				}
			}
		}
		return -1;

	}
}