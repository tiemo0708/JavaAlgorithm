package 코드트리;

import java.util.*;

public class XOR_결과_최대_만들기 {
    static int n, m;
    static int max;
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        max =0;
        dfs(0,0,0); //개수, 현재xor, 현재 인덱스
        System.out.println(max);
    }
    static void dfs(int d, int cs, int cidx){
        if(d==m){
            max = Math.max(max,cs);
            return;
        }
        if(cidx>=n || n - cidx < m-d){
            return;
        }

        dfs(d+1, cs^A[cidx], cidx+1);
        dfs(d, cs, cidx+1);
    }
}