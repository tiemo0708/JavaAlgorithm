import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<int[]>> adj = new ArrayList<>();
		
		for(int i=0; i<=n; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj.get(from).add(new int[] {to, w});
			adj.get(to).add(new int[] {from, w});
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MIN_VALUE);
		dist[start] =Integer.MAX_VALUE;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a,b)->Integer.compare(b[1], a[1])
				);
		
		pq.offer(new int[] {start, dist[start]});
		
		
		while(!pq.isEmpty()) {
			int[] current = pq.poll();
			int now = current[0];
			int weight = current[1];
			
			if(weight!=dist[now]) continue;
			if (now == end) break;
			
			for(int[] edge: adj.get(now)) {
				int next = edge[0];
				int nextWeight = edge[1];
				
				int temp = Math.min(weight, nextWeight);
				
				if(dist[next]<temp) {
					dist[next] = temp;
					pq.offer(new int[] {next, temp});
				}
			}
			
		}
		System.out.println(dist[end]);
		
	}
}