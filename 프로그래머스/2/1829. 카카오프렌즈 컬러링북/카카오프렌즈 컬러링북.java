import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
    static int aMax;
    static int count;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        aMax =0;
        count=0;
        for(int i =0; i< m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    bfs(i,j,picture);
                }
            }
        }
        numberOfArea = count;
        maxSizeOfOneArea =aMax;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static void bfs(int x, int y, int[][] arr){
        Queue<int[]> queue = new ArrayDeque<>();
        int find = arr[x][y]; // 찾아야 하는것
        int size = 1; // 영역 크기
        visited[x][y] = true;
        queue.offer(new int[]{x,y});
        
        while(!queue.isEmpty()){
            int current[] = queue.poll();
            for(int i=0; i<4; i++){
                int nx = current[0]+dx[i];
                int ny = current[1]+dy[i];
               if(nx>=0 && ny>=0 && nx < arr.length && ny<arr[0].length && !visited[nx][ny] && find == arr[nx][ny]){
                    visited[nx][ny] =true;
                    size++;
                    queue.offer(new int[] {nx,ny});
               } 
                
            }
        }
        count++;
        aMax = Math.max(size,aMax);
    }
}