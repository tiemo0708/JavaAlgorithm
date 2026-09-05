import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int rh=0, rm =0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h_1 = Integer.parseInt(st.nextToken());
			int m_1 = Integer.parseInt(st.nextToken());
			int h_2 = Integer.parseInt(st.nextToken());
			int m_2 = Integer.parseInt(st.nextToken());
			
			rm = (m_1 + m_2) % 60;
			rh = (h_1 + h_2 + ((m_1 + m_2)/60)) % 12;
			if(rh == 0) rh =12;
			
			sb.append("#").append(test_case).append(" ").append(rh).append(" ").append(rm).append("\n");
		
		}
		System.out.println(sb);
	}

}
