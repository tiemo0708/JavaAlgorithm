
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			String s = String.valueOf(i);
			int clap =0;
			for(char c: s.toCharArray()) {
				if(c =='3'||c=='6'|| c =='9') {
					clap++;
				}
			}
			if(clap==0) {
				sb.append(i).append(" ");
			}else {
				for(int j=0; j<clap; j++) {
					sb.append("-");
				}
				sb.append(" ");
			}
			
		}
		System.out.println(sb);
	
	}
}
