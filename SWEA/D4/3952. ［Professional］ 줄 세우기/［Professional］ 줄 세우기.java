
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 학생수
			int m = Integer.parseInt(st.nextToken()); // 비교수

			List<List<Integer>> arr = new ArrayList<>();
			for (int i = 0; i <=n; i++) {
				arr.add(new ArrayList<Integer>());
			}
			int[] ig = new int[n + 1];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				arr.get(to).add(from);
				ig[from]++;
			}

			Queue<Integer> queue = new ArrayDeque<Integer>();
			for (int i = 1; i <= n; i++) {
				if (ig[i] == 0) {
					queue.offer(i);
				}
			}
			
			sb.append("#").append(test_case).append(" ");
			while (!queue.isEmpty()) {
				int now = queue.poll();
				sb.append(now).append(" ");
				for (int next : arr.get(now)) {
					ig[next]--;
					if (ig[next] == 0) {
						queue.offer(next);
					}
				}

			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}
