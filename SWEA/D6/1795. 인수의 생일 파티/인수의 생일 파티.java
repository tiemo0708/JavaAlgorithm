import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			List<List<int[]>> adj = new ArrayList<>();
			List<List<int[]>> adjR = new ArrayList<>();

			for (int i = 0; i <= n; i++) {
				adj.add(new ArrayList<>());
				adjR.add(new ArrayList<>());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int go = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				adj.get(to).add(new int[] { go, w });
				adjR.get(go).add(new int[] { to, w });

			}

			int[] dist = new int[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[x] = 0;

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[1], b[1])));

			pq.offer(new int[] { x, 0 }); // 시작점, 거리

			while (!pq.isEmpty()) {
				int cur[] = pq.poll();
				int now = cur[0];
				int curDist = cur[1];

				if (curDist != dist[now])
					continue;

				for (int[] edge : adj.get(now)) {
					int next = edge[0];
					int nextDist = edge[1] + curDist;
					if (nextDist < dist[next]) {
						dist[next] = nextDist;
						pq.offer(new int[] { next, nextDist });
					}
				}
			}

			// 리버스
			int[] distR = new int[n + 1];
			Arrays.fill(distR, Integer.MAX_VALUE);
			distR[x] = 0;

			pq.offer(new int[] { x, 0 }); // 시작점, 거리
			while (!pq.isEmpty()) {
				int cur[] = pq.poll();
				int now = cur[0];
				int curDist = cur[1];

				if (curDist != distR[now])
					continue;

				for (int[] edge : adjR.get(now)) {
					int next = edge[0];
					int nextDist = edge[1] + curDist;
					if (nextDist < distR[next]) {
						distR[next] = nextDist;
						pq.offer(new int[] { next, nextDist });
					}
				}
			}

			int[] rDist = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				rDist[i] = dist[i] + distR[i];
			}
			
			int max =0;
			for (int i = 0; i < n + 1; i++) {
				max = Math.max(max, rDist[i]);
			}
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
