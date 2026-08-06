import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			boolean[] isS = new boolean[10];
			int n = Integer.parseInt(br.readLine());

			int end =0;
			int k = 0;
			while (end<10) {
				k++;
				String sc;
				sc = String.valueOf(n * k);
				
				for (char a : sc.toCharArray()) {
					if (!isS[a - '0']) {
						isS[a - '0'] = true;
						end++;
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(n*k).append("\n");
		}
		System.out.println(sb);
	}

}
