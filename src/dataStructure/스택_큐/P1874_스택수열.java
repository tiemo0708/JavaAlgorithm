package src.dataStructure.스택_큐;

import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i =0; i < N; i++){
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();

        for (int i = 0; i < A.length; i++) {
            int su = A[i];
            if(su >= num){
                while(su>=num){ //su가 아직 푸시되지 얺었더묜
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop(); // 목표까지 오면 바로 pop
                bf.append("-\n");

            }else { //목표 숫자 su가 이미 push
                int n = stack.pop();
                if(n > su){ // 스택에서 pop한 값이 su보다 크면 qnfrksmd
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if(result){
            System.out.println(bf.toString());
        }
    }
}
