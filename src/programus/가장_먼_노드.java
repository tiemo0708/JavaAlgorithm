package src.programus;

import java.util.*;

public class 가장_먼_노드 {
    public static void main(String[] args) {
        int[][] vertex = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };

        int result = solution(6, vertex);
        System.out.println(result);
    }
    public static int solution(int n, int[][] vertex){
        // 인접 리스트 생성
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i =1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        //간선 정보로 인접리스트 채우기(양방향)
        for(int[] e: vertex){
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        // dist 배열 준비, dist[i] = 1번에서 i번까지 최단거리, -1은 미방문
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        // BFS 준비 (Queue)
        Queue<Integer> q = new ArrayDeque<>();
        dist[1] = 0; //시작 노드 거리는 0
        q.add(1);

        // BFS 수행: 시작점(1)에서 모든 노드까지 최단거리 계산
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next: graph[cur]){
                //이미 방문했다면(=최단거리 확정됐다면) 스킵
                if(dist[next] != -1){
                    continue;
                }
                // 처음 방문하는 순간의 거리가 최단거리
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        // dist에서 최댓값(maxDist) 찾기
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
            }
        }


        // 최댓값과 같은 거리의 노드 개수(count) 세기
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) count++;
        }

        return count;
    }
}
