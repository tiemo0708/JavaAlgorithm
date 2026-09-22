package 코드트리;

import java.io.*;
import java.util.*;

public class 단순한동전챙기기 {

    static int N;
    static int sx, sy, ex, ey;
    static int min = Integer.MAX_VALUE;

    static List<Coin> coins = new ArrayList<>();

    static class Coin {
        int number;
        int x;
        int y;

        Coin(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                char cell = line.charAt(j);

                if (cell == 'S') {
                    sx = i;
                    sy = j;
                } else if (cell == 'E') {
                    ex = i;
                    ey = j;
                } else if (Character.isDigit(cell)) {
                    coins.add(new Coin(cell - '0', i, j));
                }
            }
        }

        // 번호가 증가하는 순서대로 탐색하기 위해 정렬
        coins.sort(Comparator.comparingInt(coin -> coin.number));

        // 현재 동전 인덱스, 선택 개수, 현재 위치, 이동 거리
        dfs(0, 0, sx, sy, 0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void dfs(int startIdx,int count,int cx,int cy,int distance) {
        // 동전 3개를 골랐다면 도착점까지 이동
        if (count == 3) {
            int totalDistance =
                    distance + getDistance(cx, cy, ex, ey);

            min = Math.min(min, totalDistance);
            return;
        }

        // 현재까지 이동한 거리도 기존 최솟값 이상이면 종료
        if (distance >= min) {
            return;
        }

        // 남은 동전을 모두 선택해도 3개를 채울 수 없는 경우
        if (coins.size() - startIdx < 3 - count) {
            return;
        }

        for (int i = startIdx; i < coins.size(); i++) {
            Coin coin = coins.get(i);


            int nextDistance =
                    distance + getDistance(cx, cy, coin.x, coin.y);

            dfs(i + 1, count + 1, coin.x, coin.y, nextDistance);
        }
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}