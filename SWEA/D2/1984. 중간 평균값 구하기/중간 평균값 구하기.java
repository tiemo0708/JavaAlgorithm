import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int max = 0;
			int min = 1000;
			double sum = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				int temp = Integer.parseInt(st.nextToken());
				max = Math.max(max, temp);
				min = Math.min(min,temp);
				sum += temp;
			}
			sum -= (max + min);
			int result = (int) Math.round(sum / 8);

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
