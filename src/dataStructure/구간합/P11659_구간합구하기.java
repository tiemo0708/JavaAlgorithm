package src.dataStructure.구간합;

import java.util.Scanner;

public class P11659_구간합구하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] S = new int[N];
        int[] T = new int[M];

        S[0] = scanner.nextInt();
        for(int i=1; i<N; i++){
            S[i] = S[i-1] + scanner.nextInt();
        }

        for(int i=0; i<M; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            if(start == 1){
                T[i] =  S[end-1];
            }
            else {
                T[i] = S[end - 1] - S[start - 2];
            }
        }

        for(int i=0; i<M; i++){
            System.out.println(T[i]);
        }
    }
}
