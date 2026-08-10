import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			
			int jump =0;
			sb.append("#").append(test_case).append("\n");
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String alp = st.nextToken();
				int count = Integer.parseInt(st.nextToken());
		
				for(int j=0; j<count; j++) {
					sb.append(alp);
					if(++jump==10) {
						sb.append("\n");
						jump=0;
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
