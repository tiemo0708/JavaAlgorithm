import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	static int len; // 자릿수
	static int N; // 교환 횟수 (자릿수로 캡 걸 것)
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			len = str.length();
			arr = new int[len];
			N = Integer.parseInt(st.nextToken());

			for (int i = 0; i < len; i++) {
				arr[i] = str.charAt(i) - '0';
			}

			if (N > len) {
				N = len;
			}

			max = 0; 
			dfs(0);
			sb.append("#").append(test_case).append(" ").append(max).append("\n");

		}
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if (depth == N) {
			int result = 0;
			for (int i = 0; i < len; i++) {
				result = result * 10 + arr[i];
			}
			max = Math.max(max, result);
			return;
		}

		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				swap(i,j);
				dfs(depth + 1);
				swap(i,j);
			}
		}

	}

	private static void swap(int i, int j) {
		int temp = arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
	}
	

}
