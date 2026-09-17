import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int max;
	static int[][] arr;
	static boolean[] visited;
	static int totalDessert;
	static int[] dx = { -1, 1, 1, -1 };
	static int[] dy = { 1, 1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());

			arr = new int[n][n];
			boolean[] dessert = new boolean[101];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dessert[arr[i][j]] = true;
				}
			}
			totalDessert = 0;
			for (int i = 1; i < 101; i++) {
				if (dessert[i])
					totalDessert++;
			}
			
			visited = new boolean[101];
			max = -1;
			root:for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					dfs(i, j, i, j, 0, 0);
					if (max >= totalDessert) {
						break root;
					}

				}
			}
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int sx, int sy, int cx, int cy, int cnt, int d) {
		if (d == 3 && sx == cx && sy == cy && cnt>3) {
			max = Math.max(cnt, max);
			return;
		}

	
		int nx = cx + dx[d];
		int ny = cy + dy[d];

		if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[arr[nx][ny]]) { // 같은 방향으로 더 갈수 있을때
			//System.out.println(arr[nx][ny]);
			visited[arr[nx][ny]] = true;
			//System.out.println(d+": 직진");
			dfs(sx, sy, nx, ny, cnt + 1, d);
			visited[arr[nx][ny]] = false;
		} 
		if(d<3){
			//System.out.println(d+": 방향전환");
			dfs(sx, sy, cx, cy, cnt, d + 1);
		}
		

	}

}
