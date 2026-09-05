import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken()); // 길의 개수

			list = new ArrayList[100];
			visited = new boolean[100];

			for (int i = 0; i < 100; i++) {
				list[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}

			sb.append("#").append(tc).append(" ").append(bfs(0)).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int next : list[now]) {
				if (next == 99) {
					return 1;
				}
				if (!visited[next]) {
					queue.offer(next);
					visited[next] = true;
				}
			}

		}
		return 0;

	}
}
