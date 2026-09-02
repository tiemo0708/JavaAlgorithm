
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			int len = str.length();

			int stackSize = 0;
			int result = 0;
			
			for(int i=0; i<len; i++) {
				if(str.charAt(i)=='(') {
					stackSize++;
				}else {
					stackSize--;
					if(str.charAt(i-1)=='(') { //레이저인 경우
						result+=stackSize; //레이저 왼쪽 나무 조각
					}else {// 나무막대의 끝 부분
						result++; //오른쪽 나무 조각
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
