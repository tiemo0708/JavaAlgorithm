import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}

			int[][] dist = new int[n][n];

			for (int i = 0; i < dist.length; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			dist[0][0] = 0;

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
			pq.offer(new int[] {0,0,0});
			int result = -1;
			while(!pq.isEmpty()) {
				int[] now = pq.poll();
				int cx = now[0];
				int cy = now[1];
				int cd = now[2];
				
				if(dist[cx][cy]!=cd) {
					continue;
				}
				
				for(int d=0; d<4; d++) {
					int nx = cx+dx[d];
					int ny = cy+dy[d];
					
					if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
					
					if(dist[nx][ny]>cd+map[nx][ny]) {
						dist[nx][ny] = cd+map[nx][ny];
						if(nx==n-1 && ny==n-1) {
							result = dist[nx][ny];
						}
					
						pq.offer(new int[] {nx, ny, dist[nx][ny]});
					}
					
					
				}
				
			}
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}

}
