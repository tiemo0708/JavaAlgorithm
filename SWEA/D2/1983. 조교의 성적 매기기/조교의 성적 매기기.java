import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //학생수
			int k = Integer.parseInt(st.nextToken()); //1이상 n이하
			int[] socres = new int[n]; //점수
			int tS = 0; //학점 알고싶은 학생의 점수
			double grade = n; // 순위
			for(int i =0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				socres[i] = a*35 + b*45 + c*20;
				if(k-1==i) {
					tS = socres[i];
				}
			}
			Arrays.sort(socres);
			for(int score: socres) {
				if(score == tS) {
					break;
				}
				grade--;
			}
			sb.append("#").append(test_case).append(" ");
			if(grade*10/n<=1) {
				sb.append("A+");
			}else if(grade*10/n<=2) {
				sb.append("A0");
			}else if(grade*10/n<=3) {
				sb.append("A-");
			}else if(grade*10/n<=4) {
				sb.append("B+");
			}else if(grade*10/n<=5) {
				sb.append("B0");
			}else if(grade*10/n<=6) {
				sb.append("B-");
			}else if(grade*10/n<=7) {
				sb.append("C+");
			}else if(grade*10/n<=8) {
				sb.append("C0");
			}else if(grade*10/n<=9) {
				sb.append("C-");
			}else {
				sb.append("D0");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}