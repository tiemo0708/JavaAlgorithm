package src.탐색.백트래킹;

import java.util.Scanner;

public class P9663_N_Queen {
    static int[] A;
    static int N;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        
        backtracking(0);
        System.out.println(cnt);
    }

    private static void backtracking(int row) {
        if (row == N) { //정답 출력
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) { //모든 경우의 수 탐색
            A[row] = i;
            if(check(row)){ // 가지치기 유효성 검사
                backtracking(row + 1);
            }
        }
    }

    private static boolean check(int row) {
        for (int i =0; i<row; i++) {
            if(A[row] == A[i]) return false; //일직선 공격
            if (Math.abs(row-i)==Math.abs(A[row]-A[i])) return false; //대각선 공격
        }
        return true;
    }
}
