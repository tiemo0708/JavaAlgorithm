import java.util.*;
class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer;
    public int solution(int[][] maps) {
        answer = 0;
        
        answer=bfs(0,0,maps); // x, y
        
        return answer;
    }
    static int bfs(int x, int y, int[][] maps){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y,1});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx<0||ny<0||nx>=maps.length||ny>=maps[0].length||maps[nx][ny]!=1) continue;
                if(nx == maps.length-1 && ny== maps[0].length-1){
                    return current[2]+1;
                }
                maps[nx][ny] = 2;
                queue.offer(new int[]{nx,ny,current[2]+1});
            }
            
        }
        return -1;
    }
}