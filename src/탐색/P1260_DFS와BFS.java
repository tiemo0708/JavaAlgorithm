package src.탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1260_DFS와BFS {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N+1];

    for (int i = 1; i <= N; i++) {
        graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        graph[a].add(b);
        graph[b].add(a);
    }

    for(int i =1; i <= N; i++){
        Collections.sort(graph[i]);
    }

    visited = new boolean[N+1];
    dfs(V);
    sb.append('\n');

    visited =  new boolean[N+1];
    bfs(V);

    System.out.print(sb);

    }

    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

    }

    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(' ');
        for(int next: graph[node]){
            if(!visited[next]){
                dfs(next);
            }

        }
    }
}
