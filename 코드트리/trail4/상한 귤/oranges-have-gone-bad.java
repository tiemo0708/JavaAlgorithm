import java.util.*;

public class Main {;
    static int n, k;
    static int[][] grid;
     static int[][] rgrid;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt(); // 상한귤 개수
        grid = new int[n][n];
        rgrid = new int[n][n];

        for(int[] g: rgrid){
            Arrays.fill(g,-2);
        }
        arr= new int[k][2]; //상한귤 좌표

        int c =0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] ==2){
                    arr[c][0] = i;
                    arr[c][1] = j;
                    c++;
                }else if(grid[i][j] ==0){
                    rgrid[i][j] = -1;
                }
            }
        }
        bfs();
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(rgrid[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void bfs(){
        Deque<int[]> queue = new ArrayDeque<>();
       
        for(int i = 0; i<k; i++){
            int x = arr[i][0];
            int y = arr[i][1];
            rgrid[x][y] = 0;
            queue.offer(new int[]{x, y, 1});
        }

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];
            int time = now[2];

            for(int d=0; d<4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx<0 || ny<0 || nx>=n || ny>=n || grid[nx][ny]!=1) continue;
                rgrid[nx][ny] = time;
                grid[nx][ny] = 2;
                queue.offer(new int[]{nx, ny, time+1});
            }
        }
    }
}