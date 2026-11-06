import java.util.*;

public class Main {
    static int n,k;
    static int[][] grid;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        dist = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(dist[i],-1);
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 2) dist[i][j] = 0;
            }
        }
        

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j] ==1){
                    visited = new boolean[n][n];
                    dist[i][j] = bfs(i,j);
                }

            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(dist[i][j]+" ");
                
            }
            System.out.println();
        }
    }

    static int bfs(int row, int col){
        Queue<int[]> q = new ArrayDeque<>();

        visited[row][col] = true;
        q.offer(new int[]{row,col,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y= cur[1];
            int cost = cur[2];

            if(grid[x][y] == 2) return cost;

            for(int i=0; i<4; i++){
                int nx = x +dx[i];
                int ny = y + dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n) continue;

                if(visited[nx][ny]) continue;

                if(grid[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx,ny,cost+1});
            }
        }
        return -2;
    }
}