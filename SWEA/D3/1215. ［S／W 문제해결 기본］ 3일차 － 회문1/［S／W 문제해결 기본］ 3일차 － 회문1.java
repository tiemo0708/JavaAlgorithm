import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int m = Integer.parseInt(br.readLine()); // 찾을 회문 길이
            int n = 8; // 8x8 고정

            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            int horizontalCount = countHorizontal(board, n, m);
            char[][] transposed = transpose(board, n);
            int verticalCount = countHorizontal(transposed, n, m);

            int total = horizontalCount + verticalCount;
            sb.append("#").append(tc).append(" ").append(total).append("\n");
        }

        System.out.print(sb);
    }

    // 투 포인터로 회문 판별
    static boolean isPalindrome(char[] arr, int len) {
        int left = 0;
        int right = len-1;          // (1)
        while (left<right) {             // (2)
            if (arr[left] != arr[right]) return false; // 하나씩 비교해서 틀리면 바로 리턴
            left++;                  // (3)
            right--;                  // (4)
        }
        return true;
    }

    // 가로 방향 회문 개수 세기
    static int countHorizontal(char[][] board, int n, int m) { //배열, 배열 길이, 찾을 회문 길이
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n-m; j++) {   // (5) 전체 길이에서 찾을 회문길이 뺀만큼 밀어가면서 찾기
                char[] sub = new char[m]; // 자른 걸로 새 배열 만들기
                for (int k = 0; k < m; k++) {
                	sub[k] = board[i][j+k];  // (6)
                }
                if (isPalindrome(sub, m)) cnt++;
            }
        }
        return cnt;
    }

    // 전치행렬 만들기 (행<->열 교환)
    static char[][] transpose(char[][] board, int n) {
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = board[j][i];
            }
        }
        return result;
    }
}