import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                visited[i] = true;
                queue.offer(i);
                
                while(!queue.isEmpty()){
                    int current = queue.poll();
                    for(int j=0; j<n; j++){
                        if(computers[current][j]==1 && !visited[j]){
                            visited[j] = true;
                            queue.offer(j);
                        }
                            
                    }
                }
            }
        }
        
        return answer;
    }
}