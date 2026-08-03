import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int money = Integer.parseInt(br.readLine());
			int count = 0;

			sb.append("#").append(test_case).append("\n");
			// 50,000
			count = money / 50000;
			money = money % 50000;
			sb.append(count).append(" ");

			// 10,000
			count = money / 10000;
			money = money % 10000;
			sb.append(count).append(" ");

			// 5,000
			count = money / 5000;
			money = money % 5000;
			sb.append(count).append(" ");

			// 1,000
			count = money / 1000;
			money = money % 1000;
			sb.append(count).append(" ");

			// 500
			count = money / 500;
			money = money % 500;
			sb.append(count).append(" ");

			// 100
			count = money / 100;
			money = money % 100;
			sb.append(count).append(" ");

			// 50
			count = money / 50;
			money = money % 50;
			sb.append(count).append(" ");

			// 10
			count = money / 10;
			money = money % 10;
			sb.append(count).append("\n");

		}
		System.out.println(sb);
	}

}
