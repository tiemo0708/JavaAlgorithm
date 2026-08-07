import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[] m_day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for (int test_case = 1; test_case <= T; test_case++) {
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f_m = Integer.parseInt(st.nextToken());
		int f_d = Integer.parseInt(st.nextToken());
		int s_m = Integer.parseInt(st.nextToken());
		int s_d = Integer.parseInt(st.nextToken());
		int result =0;
		for(int i =f_m-1; i<s_m; i++) {
			result +=m_day[i];
		}
		result -= (f_d +(m_day[s_m-1]-s_d)-1);
				
			
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
