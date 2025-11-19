package src.정렬.선택정렬;

import java.util.Scanner;

public class P1427_내림차순 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] a = new int[str.length()];

        for(int i =0; i<str.length(); i++){
            a[i] = Integer.parseInt(str.substring(i, i+1));
        }

        //선택 정렬
        for(int i =0; i<str.length(); i++){
            int max =i;
            for(int j = i+1; j<str.length(); j++){
                if(a[max]<a[j]){
                    max = j;
                }
            }
            if(a[max]>a[i]){
                int temp = a[max];
                a[max] = a[i];
                a[i] = temp;
            }
        }
        for(int i =0; i<str.length(); i++){
            System.out.print(a[i]);
        }
    }
}
