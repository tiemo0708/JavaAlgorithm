package src.dataStructure.출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10992_별찍기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){

            // 좌측 공백
//            for(int j = i; j<N; j++){
//                sb.append(" ");
//            }
            sb.append(" ".repeat(Math.max(0, N - i)));
            if (i == N) {
                // 마지막 줄: 별을 꽉 채우기
                sb.append("*".repeat(Math.max(0, 2 * i - 1)));
            } else {
                // 마지막 줄이 아닐 때: 속이 빈 삼각형
                int width = 2 * i - 1; // 현재 줄 전체 폭

                for (int j = 0; j < width; j++) {
                    // 왼쪽 끝 또는 오른쪽 끝 위치
                    if (j == 0 || j == width - 1) {
                        sb.append("*");
                    } else {
                        sb.append(" "); // 내부 공백
                    }
                }
            }

            sb.append("\n"); // 줄바꿈
        }

        System.out.println(sb);
    }
}
