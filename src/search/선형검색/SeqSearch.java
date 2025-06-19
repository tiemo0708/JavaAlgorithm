package src.search.선형검색;

import java.util.Scanner;

// 선형검색
class SeqSearch {

    static int seqSearch(int[] a, int n, int key) {
     for (int i = 0; i < n; i++) {
         if(a[i] == key)
             return i;
     }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x =new int[num]; //요솟수가 num인 배열

        for(int i=0; i< num; i++){
            System.out.print("X["+i+"]:");
            x[i] = sc.nextInt();
        }

        System.out.print("검색할 값: ");
        int ky = sc.nextInt();

        int idx = seqSearch(x, num, ky); //배열 x에서 키값이 ky인 요소 검색

        if(idx == -1)
            System.out.println("그 값의 요소가 없습니다");
        else
            System.out.println(idx);
    }
}

