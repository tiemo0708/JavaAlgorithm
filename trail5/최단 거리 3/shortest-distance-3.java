import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<int[]>> adj = new ArrayList<>();

        for(int i =0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
            
        }

        int s = sc.nextInt();
        int e = sc.nextInt();

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
       
       PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a,b) -> Integer.compare(a[1],b[1])
       );
        pq.offer(new int[]{s,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int curDist = cur[1];
            
            if(curDist != dist[now]) continue;
            for(int[] edge : adj.get(now)){
                int next = edge[0];
                int nextDist = edge[1] + curDist;

                if(dist[next]>nextDist){
                    dist[next] = nextDist;
                    pq.offer(new int[]{next, nextDist});
                }

            }

        }

        System.out.println(dist[e]);
    }
}