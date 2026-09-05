import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String str = st.nextToken();

			Deque<Character> stack = new ArrayDeque<Character>();

			for (int i = 0; i < n; i++) {
				char c = str.charAt(i);
				if (!stack.isEmpty() && stack.peek() == c) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}

			StringBuilder result = new StringBuilder(); // 스택은 역순이라 뒤집어서
			while (!stack.isEmpty()) {
				result.append(stack.pop());
			}
			result.reverse();
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
