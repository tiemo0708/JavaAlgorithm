package src.dataStructure.투포인터;

import java.util.Scanner;

public class P2028_연속된자연수의합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1, start_index= 1, end_index = 1, sum = 1;

        while(end_index!=N){
            if(sum==N) {
                count++; end_index++; sum = sum + end_index;
            }else if(sum>N){
                sum = sum - start_index;
                start_index++;
            }else {
                end_index++; sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}
