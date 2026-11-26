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

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		List<List<int[]>> adj = new ArrayList<>();

		for (int i = 0; i <= v; i++) {
			adj.add(new ArrayList<>());
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<e; i++) {
			 st = new StringTokenizer(br.readLine());
			 int from = Integer.parseInt(st.nextToken());
			 int to = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken());
			 
			adj.get(from).add(new int[] {to,w});
		}
		
		int[] degree = new int[v+1];
		Arrays.fill(degree, Integer.MAX_VALUE);
		degree[k] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a,b) -> Integer.compare(a[1], b[1])
				);
		
		
		pq.offer(new int[] {k, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int now = cur[0];
			int cw = cur[1];
			
			if(degree[now]!=cw) continue;
			
			for(int[] edge: adj.get(now)) {
				int next = edge[0];
				int nextW = cw+edge[1];
				
				if(degree[next]>nextW) {
					degree[next] = nextW;
					pq.offer(new int[] {next, nextW});
				}
				
			}
			
		}
		for(int i =1; i<=v; i++) {
			System.out.println((degree[i]==Integer.MAX_VALUE) ? "INF":degree[i]);
		}
	}
}