package src.SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1979_스도쿠검증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
        int [][] map = new int[9][9];
        for (int i =0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        int answer =1;
            for (int i =0; i<9; i++){
                boolean[] check = new boolean[10];
                for (int j = 0; j<9; j++){
                    int num = map[i][j];
                    if(check[num]){
                        answer=0;
                    }
                    check[num] = true;
                }
            }

            for (int j =0; j<9; j++){
                boolean[] check = new boolean[10];
                for (int i = 0; i<9; i++){
                    int num = map[i][j];
                    if(check[num]){
                        answer=0;
                    }
                    check[num] = true;
                }
            }

            for (int r = 0; r<9; r+=3){
                for(int c =0; c<9; c+=3){
                    boolean[] check = new boolean[10];

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            int num = map[r + i][c + j];
                            if (check[num]) answer = 0;
                            check[num] = true;
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append('\n');
        }
        System.out.print(sb.toString());
    }
}
