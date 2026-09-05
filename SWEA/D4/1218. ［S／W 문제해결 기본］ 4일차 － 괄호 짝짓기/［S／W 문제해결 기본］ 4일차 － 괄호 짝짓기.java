import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();

			char[] arr = new char[n];

			for (int i = 0; i < n; i++) {
				arr[i] = str.charAt(i);
			}

			int result = 1;
			Deque<Character> stack = new ArrayDeque<>();
			stack.push(arr[0]);

			for (int i = 1; i < n; i++) {
				if (arr[i] == ')' || arr[i] == '>' || arr[i] == ']' || arr[i] == '}') {
					if (stack.peek() == '(' && arr[i] == ')') {
						stack.pop();
					} else if (stack.peek() == '<' && arr[i] == '>') {
						stack.pop();
					} else if (stack.peek() == '[' && arr[i] == ']') {
						stack.pop();
					} else if (stack.peek() == '{' && arr[i] == '}') {
						stack.pop();
					} else { // 닫히는게 맞지 않는경
						result = 0;
						break;
					}
				} else { // 열리는거일때
					stack.push(arr[i]);
				}

			}
			if (!stack.isEmpty()) { // 짝이 안맞으면
				result = 0;
			}

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
