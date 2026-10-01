import java.util.*;
class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];
        

        dfs(k, dungeons,0);
        return answer;
    }
    static void dfs(int k, int[][] dungeons, int cnt){
        
        answer = Math.max(answer,cnt);
        
        for(int i =0; i<dungeons.length; i++){
            if(dungeons[i][0]<= k && !visited[i]){
                visited[i] = true;
                dfs(k-dungeons[i][1],dungeons, cnt+1);
                visited[i] = false;
            }
        }
    }
}