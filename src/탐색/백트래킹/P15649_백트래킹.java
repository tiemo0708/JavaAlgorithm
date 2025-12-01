package src.탐색.백트래킹;

import java.util.Scanner;

public class P15649_백트래킹 {
    static int N, M;
    static boolean[] V;
    static int[] S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        S = new int[N];
        V = new boolean[N];
        backtraking(0); //현재 포함된 수열이 몇개인지
    }

    private static void backtraking(int length) {
        if(length == M){ //정답인지 확인해 리턴
            //수열 출력
            printArray();
            return;
        }
        for (int i = 0; i < N; i++) { //갈 수 있는 모든 선택지
                if (!V[i]) {
                    V[i] = true;
                    S[length] = i;
                    backtraking(length + 1);
                    V[i] = false;
                }
        }
    }

    private static void printArray() {
        for (int i = 0; i < N; i++) {
            System.out.println(S[i]+ 1+ " ");
        }
    }
}
