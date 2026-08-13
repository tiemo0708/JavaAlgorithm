import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int[] arr; // 체스판
	static int n;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			count = 0;
			dfs(0); // row 넣기
			sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int row) {
		if(row==n) {
			count++;
			return;
		}
		for(int i=0; i<n; i++) {
			arr[row] = i;
			if(check(row)) {
				dfs(row+1);
			}
		}

	}

	private static boolean check(int row) {
		for(int i=0; i< row; i++) {
			if(arr[row]==arr[i]) return false; //직선
			if(Math.abs(row-i)==Math.abs(arr[row]-arr[i])) return false; //대각선
		}
		return true;
	}
}
