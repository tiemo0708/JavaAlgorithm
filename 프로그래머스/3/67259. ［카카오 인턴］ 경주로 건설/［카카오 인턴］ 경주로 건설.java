import java.util.*;

class Solution {
static int[] dx = {-1,1,0,0};
static int[] dy = {0,0,-1,1};
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[][][] dist = new int[n][n][4];
        
        for(int[][] row : dist){
            for(int [] cell: row){
                Arrays.fill(cell, Integer.MAX_VALUE);
            }
        }
        
        Arrays.fill(dist[0][0],0);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[3], b[3])
        );
        
        pq.offer(new int[]{0,0,1,0}); // 하
        pq.offer(new int[]{0,0,3,0}); // 우
  
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int cx = now[0];
            int cy = now[1];
            int cd = now[2]; // 방향  
            int cdist = now[3];
            
            if(cdist!=dist[cx][cy][cd]){
                continue;
            }
            
            for(int d=0; d<4; d++){
                int nx = cx + dx[d];
            
                int ny = cy + dy[d];
                if(nx<0 || ny <0 || nx>=n || ny>= n || board[nx][ny] == 1) continue;
                
                if(cd==d){
                    if(cdist+100<dist[nx][ny][d]){
                         dist[nx][ny][d] = cdist+100;
                
                         pq.offer(new int[]{nx,ny,d,cdist+100});
                    }
                }else{
                     if(cdist+600<dist[nx][ny][d]){
                        dist[nx][ny][d] = cdist+600;
                        
                        pq.offer(new int[]{nx,ny,d,cdist+600});
                    }
                }
            }
            
        }
        
        answer = Math.min(dist[n-1][n-1][1],dist[n-1][n-1][3]);
        
        return answer;
    }
}