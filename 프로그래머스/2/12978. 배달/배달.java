import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<int[]>> g = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] arr : road) {
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            g.get(a).add(new int[]{b, c});
            g.get(b).add(new int[]{a, c});
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], d = cur[1];

            if (d > dist[node]) continue;

            for (int[] edge : g.get(node)) {
                int next = edge[0], weight = edge[1];
                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}