import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static char[][] arr = new char[4][4];
	static Set<String> numSet;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = st.nextToken().charAt(0);
				}
			}
			numSet = new HashSet<>();

			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					dfs(0, "", x, y);
				}
			}
			sb.append("#").append(test_case).append(" ").append(numSet.size()).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int depth, String str, int cx, int cy) {
		str += arr[cx][cy]; // 현재 위치 값 추가
		if (depth == 6) {
			numSet.add(str);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];
			if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
				dfs(depth+1,str,nx,ny);
				str.substring(0, str.length()-1);
			}

		}
	}
}
