package src.탐욕알고리즘;

import java.util.Scanner;

public class P11047_동전개수의최솟값
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a[] = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        // 그리디 알고리즘 -> 최대한 큰 동전 먼저 사용하기
        int count = 0;
        for(int i = n-1; i>=0; i--){
            if(a[i] <= k){
                count += (k/a[i]); //동전수 계산
                k = k % a[i];
            }
        }
        System.out.println(count);
    }
}
