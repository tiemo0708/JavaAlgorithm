import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int maxLen;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T =Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()); //정점
			int m = Integer.parseInt(st.nextToken()); //간선
			
			adjList = new ArrayList[n+1];
			
			for(int i=1; i<n+1; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); 
				int y = Integer.parseInt(st.nextToken()); 
				adjList[x].add(y);
				adjList[y].add(x);
			}
			visited = new boolean[n+1];
			maxLen =0;
			for(int start=1; start<n+1; start++) {
				dfs(start, 1);
			}
			sb.append("#").append(test_case).append(" ").append(maxLen).append("\n");
		}
		System.out.println(sb);
		
	}

	private static void dfs(int start, int depth) {
		maxLen = Math.max(maxLen, depth);
		visited[start] = true;
		
		for(int next: adjList[start]) {
			if(!visited[next]) {
				dfs(next, depth+1);
			}
		}
		visited[start] = false;
	}

}
