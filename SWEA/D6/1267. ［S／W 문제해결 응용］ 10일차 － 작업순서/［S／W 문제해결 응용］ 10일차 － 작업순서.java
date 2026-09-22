import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); 
			int E = Integer.parseInt(st.nextToken()); 

			List<List<Integer>> adj = new ArrayList<>();

			for (int i = 0; i <= V; i++) {
				adj.add(new ArrayList<>());
			}
			
			int[] indegree = new int[V + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken()); 
				int to = Integer.parseInt(st.nextToken());
				adj.get(from).add(to);
				indegree[to]++;
			}

			Queue<Integer> queue = new ArrayDeque<>();
			
			for(int i=1; i<=V; i++) {
				if(indegree[i]==0) {
					queue.offer(i);
				}
			}
			sb.append("#").append(test_case);
			while(!queue.isEmpty()) {
				int now = queue.poll();
				sb.append(" ").append(now);
				for(int next: adj.get(now)) {
					indegree[next]--;
					if(indegree[next]==0) {
						queue.offer(next);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
