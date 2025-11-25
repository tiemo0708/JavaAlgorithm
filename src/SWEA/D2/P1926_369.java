package src.SWEA.D2;

import java.util.Scanner;

public class P1926_369 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();

        for(int i =1; i<=n; i++){
            String s = String.valueOf(i);
            int clap = 0;
            for(char c: s.toCharArray()){
                if(c== '3' || c== '6' || c== '9'){
                    clap++;
                }
            }
            if(clap==0){
                System.out.print(i);
            }
            else{
                for (int j =0; j<clap; j++){
                    System.out.print("-");
                }
            }
            if (i!=n) {
                System.out.print(" ");
            }
        }

    }
}
