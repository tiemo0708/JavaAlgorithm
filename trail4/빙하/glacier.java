import java.util.*;

public class Main {
    // 우하좌상
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int n, m;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        int time =0;
        int lastCount=0;
        while (true) {
            List<int[]> melting = bfs();

            if (melting.isEmpty()) {
                break;
            }
            for(int cell[]: melting){
                grid[cell[0]][cell[1]] = 0;
            }
            time++;
            lastCount = melting.size();
        }
        System.out.println(time+" "+ lastCount);
    }

    static List<int[]> bfs() {
        List<int[]> melting = new ArrayList<>(); // 녹은 빙하
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]) continue;

                 visited[nx][ny] = true;

                if(grid[nx][ny]==0){
                    queue.offer(new int[]{nx,ny});
                }else{
                    melting.add(new int[]{nx,ny});
                }

            }
        
        }
        return melting;
    }
}