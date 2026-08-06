import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			char[] befor = new char[str.length()];
			char[] reset = new char[str.length()];

			int idx = 0;
			for (char c : str.toCharArray()) {
				befor[idx] = c;
				reset[idx] = '0';
				idx++;
			}

			int result = 0;
			for (int i = 0; i < str.length(); i++) {
				if (befor[i] != reset[i]) {
					for (int j = i; j < str.length(); j++) {
						reset[j] = befor[i];
					}
					result++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
