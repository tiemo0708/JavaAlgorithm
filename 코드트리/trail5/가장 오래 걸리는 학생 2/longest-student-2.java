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
        
        for(int i=0; i< m; i++){
             int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            adj.get(b).add(new int[]{a,c});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[n]=0;

        //정점번호, 거리
        PriorityQueue<int[]> pq = new  PriorityQueue<>(
            (a,b) ->Integer.compare(a[1],b[1])
        );
        pq.offer(new int[]{n,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int curDist = cur[1];

            if(curDist != dist[now]) continue;

            for(int[] edge: adj.get(now)){
                int next = edge[0];
                int nextDist = curDist + edge[1];
                if(nextDist < dist[next]){
                    dist[next] = nextDist;
                    pq.offer(new int[]{next, nextDist});
                }
            }
        }
        int answer =0;
        for(int i =1; i<n; i++){
            answer = Math.max(answer, dist[i]);
        }
        System.out.println(answer);
    }
}