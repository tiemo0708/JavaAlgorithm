import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int arr[];
	static int sum;
	static int n;
	static int k;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			arr = new int[n];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			count = 0;
			sum = 0;
			for (int i = 0; i < n; i++) {
				dfs(i);
				sum -= arr[i];
			}
			sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int v) {
		sum += arr[v];
		if (sum == k) {
			count++;
			return;
		} else if (sum > k) {
			return;
		}
		for (int i = v + 1; i < n; i++) {
				dfs(i);
				sum -= arr[i];
		
		}

	}

}
