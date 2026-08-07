import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			List<Integer> list = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			for (char c : s.toCharArray()) {
				list.add(c - '0');
			}

			for (int i = 1; i < n; i++) {
//				System.out.println("n: " + n + "i: " + i);
//				System.out.println(list.get(i - 1) + " : " + (list.get(i)));
//				System.out.println("테케 " + test_case);
				if (list.get(i) == list.get(i - 1)) {
					list.remove(i);
					list.remove(i - 1);
					n -= 2;
					if (i > 1) {
						i -= 2;
					}
				}
			}
			sb.append("#").append(test_case).append(" ");
			for (int num : list) {
				sb.append(num);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
