package src.dataStructure.투포인터;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()); //빠른 입출력을 위해(한줄에 여러개 받을때)
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;

        //투포인터 시작과 끝 지점
        int i = 0; //A[0] -> min
        int j = N-1; //A[N-1] -> max

        while (i < j) {
            if(A[i]+A[j]<M){
                i++;
            }
            else if(A[i]+A[j]>M){
                j--;
            }
            else{
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
    }
}
