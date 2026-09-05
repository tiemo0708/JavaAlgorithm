package 코드트리;
import java.util.*;
public class 자동차_전시장 {
    static boolean[] visited;
    static int[] time; // 시작점중 가장 늦게
    static boolean[] invalid; //도착 목하면 판정에서 제거
    static List<List<Integer>> adj; //인접리스트
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
        }
        int[] startPoints = new int[k];
        for (int i = 0; i < k; i++) {
            startPoints[i] = sc.nextInt();
        }
        // Please write your code here.
        time = new int[n+1];
        invalid = new boolean[n+1];
        Arrays.fill(time,-1); // 도달 못할시 -1

        for(int start : startPoints){
            visited = new boolean[n+1];
            bfs(start,n);
        }
        int min = 1000001;
        for(int i=1; i<time.length; i++){
            if (!invalid[i]) {
                min = Math.min(min,time[i]);
            }
        }
        if (min == 1000001) {
            min = -1;
        }
        System.out.println(min);
    }
    private static void bfs(int start, int n){

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start,0}); // 현재위치, 현재 깊이
        visited[start] = true;
        time[start] = Math.max(time[start], 0);
        while(!queue.isEmpty()){
            int[] curPair = queue.poll();

            int cur = curPair[0];
            int depth = curPair[1];

            for(int next : adj.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    int nextDepth = depth + 1;
                    time[next] = Math.max(nextDepth, time[next]);
                    queue.offer(new int[]{next, nextDepth});
                }
            }
        }
        for(int v =1; v<=n; v++){
            if (!visited[v]) {
                invalid[v] = true;
            }
        }
    }
}