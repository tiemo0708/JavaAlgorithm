package src.search.이진검색;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int [] x = new int[num]; //요솟수가 num인 배열

        System.out.println("오름차순으로 입력하세요");
        System.out.print("x[0]: "); // 첫 요소 입력
        x[0] =sc.nextInt();

        for(int i=1;i<num;i++){
            do{
                System.out.print("x["+i+"]: ");
                x[i] =sc.nextInt();
            }while(x[i]<x[i-1]); // 바로 앞 요소보다 작으면 다시 입력
        }

        System.out.print("검색할 값: ");
        int ky = sc.nextInt();

        int idx = Arrays.binarySearch(x, ky);

        if(idx==-1){
            System.out.println("그 값의 요소가 없습니다.");
        }else
        {
            System.out.println("ky는 "+ idx + "에 있음");
        }

    }
}
