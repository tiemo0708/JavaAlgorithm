import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[5];

			int n = Integer.parseInt(br.readLine());

			while (n != 1) {
				if (n % 2 == 0) {
					n /= 2;
					arr[0]++;
				}
				if (n % 3 == 0) {
					n /= 3;
					arr[1]++;
				}
				if (n % 5 == 0) {
					n /= 5;
					arr[2]++;
				}
				if (n % 7 == 0) {
					n /= 7;
					arr[3]++;
				}
				if (n % 11 == 0) {
					n /= 11;
					arr[4]++;
				}
			}
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < 5; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
