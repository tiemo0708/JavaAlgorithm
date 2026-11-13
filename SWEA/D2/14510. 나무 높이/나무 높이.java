import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T =Integer.parseInt(br.readLine());		
		for(int test_case = 1; test_case <= T; test_case++){
		
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int maxH=0;
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, arr[i]);
			}
			int one = 0;
			int two = 0;
			for(int i=0; i<n; i++) {
				int h = maxH - arr[i];
				one += h%2;
				two += h/2;
			}
			while(two>one+1) {
				two--;
				one = one+2;
			}
			int result = Math.max(one*2-1, two*2);
			   sb.append('#').append(test_case).append(' ')
	              .append(result).append('\n');
		}
		System.out.println(sb);
		
	}

}
