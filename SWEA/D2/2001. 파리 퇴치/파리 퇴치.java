/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 1-based index를 쓰기 위해 N+1 x N+1 배열 사용
            int[][] ps = new int[N + 1][N + 1];  // prefix sum 배열

            // 격자 입력 + 동시에 2차원 누적합 계산
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    int val = Integer.parseInt(st.nextToken());

                    // 2D prefix sum: ps[i][j]
                    ps[i][j] = val
                            + ps[i - 1][j]
                            + ps[i][j - 1]
                            - ps[i - 1][j - 1];
                }
            }

            int max = 0;

            // 파리채의 왼쪽 위 좌표 (i, j)를 전부 시도
            for (int i = 1; i <= N - M + 1; i++) {
                for (int j = 1; j <= N - M + 1; j++) {
                    int x1 = i;
                    int y1 = j;
                    int x2 = i + M - 1;
                    int y2 = j + M - 1;

                    // (x1, y1) ~ (x2, y2) 사각형 합
                    int sum = ps[x2][y2]
                            - ps[x1 - 1][y2]
                            - ps[x2][y1 - 1]
                            + ps[x1 - 1][y1 - 1];

                    if (sum > max) {
                        max = sum;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append('\n');
        }

        System.out.print(sb.toString());
    }
}
