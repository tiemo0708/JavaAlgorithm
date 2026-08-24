import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	static int n;
	static int max;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			n = Integer.parseInt(st.nextToken());
			arr = new int[str.length()];
			for(int i=0; i<str.length(); i++) {
				arr[i] = str.charAt(i)-'0';
			}
			
			if(n>str.length()) {
				n=str.length();
			}
			max=0;
			visited= new boolean[n+1][(int) Math.pow(10, str.length())]; //최대 자릿수
			dfs(0); //시작점
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}
	private static void dfs(int depth) {
		int sum = 0;
		for(int v: arr) {
			sum = sum*10+v;
		}
		if(visited[depth][sum]) {
			return;
		}
		visited[depth][sum] = true;
		
		if(depth==n) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i =0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				swap(i,j);
				dfs(depth+1);
				swap(i,j);
			}
		}
		
	}
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
