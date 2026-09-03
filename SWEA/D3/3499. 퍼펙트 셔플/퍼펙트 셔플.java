
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine()); // 카드 숫자
			String[] lCards = new String[(n / 2) + (n % 2)]; // 홀수면 한장더
			String[] rCards = new String[n / 2];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < lCards.length; i++) {
				lCards[i] = st.nextToken();
			}
			for (int i = 0; i < rCards.length; i++) {
				rCards[i] = st.nextToken();
			}
			sb.append("#").append(test_case);
			for(int i=0; i<rCards.length; i++) {
				sb.append(" ").append(lCards[i]).append(" ").append(rCards[i]);
			}
			if(n%2==1) { //홀수면
				sb.append(" ").append(lCards[lCards.length-1]);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

}
