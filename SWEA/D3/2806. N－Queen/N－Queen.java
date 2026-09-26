import java.io.BufferedReader;
import java.io.InputStreamReader;


class Solution {
	static int arr[];
	static int n;
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			n = Integer.parseInt(br.readLine());
			cnt =0;
			arr = new int[n];
			dfs(0); // row
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		
		}
		System.out.println(sb);
		
	}
	private static void dfs(int r) {
		//완료 조건
		if(r==n) {
			cnt++;
			return;
		}
		
		for(int i =0; i<n; i++) {
			arr[r] =i;
			if(check(r)) {
				dfs(r+1);
			}
			
		}
		
		
	}
	private static boolean check(int r) {
		
		for(int i =0; i<r; i++) {
			if(arr[r] == arr[i]) return false;
			if(Math.abs(r-i) == Math.abs(arr[r]-arr[i])) return false;
		}
		
		return true;
	}

}
