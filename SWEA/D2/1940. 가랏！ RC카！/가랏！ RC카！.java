import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			int m = 0; // 이동거리
			int speed = 0; // 현재속도
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());

				int s = 0;
				if (c != 0) {
					s = Integer.parseInt(st.nextToken());
				}
				if (c == 1) {
					speed += s;
				} else if (c == 2) {
					if (s > speed) {
						speed = 0;
					} else {
						speed -= s;
					}
				}
				m += speed;
			}
			sb.append("#").append(test_case).append(" ").append(m).append("\n");
		}
		System.out.println(sb);
	}
}
