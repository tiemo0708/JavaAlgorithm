package src.탐색.BFS;

import java.util.*;

public class 네트워크 {
    public static void main(String[] args) {
        Solution43162 solution = new Solution43162();

        // 예제 1
        int n1 = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution.solution(n1, computers1));
        // 예상 출력: 2

        // 예제 2
        int n2 = 3;
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution.solution(n2, computers2));
        // 예상 출력: 1
    }
}

class Solution43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && computers[cur][j] == 1) {
                            visited[j] = true;
                            queue.add(j);
                        }
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}