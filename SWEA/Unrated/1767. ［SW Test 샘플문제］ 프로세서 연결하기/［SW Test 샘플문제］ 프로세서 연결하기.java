
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int N, max, totalCnt, min, map[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<int[]> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];// 0:빈공간, 1: 코어, 2: 설치된 전선
			list = new ArrayList<int[]>();
			max = 0; // 최대연결 코어
			min = Integer.MAX_VALUE; // 최대연결 코어를 연결했을때 최소전선 길이
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i > 0 && i < N - 1 && j > 0 && j < N - 1 && map[i][j] == 1) { // 가장자리가 아닌 코어는 리스트에 추가
						list.add(new int[] { i, j });// 코어의 좌표
					}
				}
			}
			totalCnt = list.size(); // 가장자리가 아닌 코어 개수
			go(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	// index:부분집합에 고려할 코어 인덱스,cCnt : 현재까지 연결된 코어수, lCnt: 현재까지 연결된 코어전선
	private static void go(int index, int cCnt, int lCnt) {
		// 가지치기
		if (totalCnt - index + cCnt < max) { // totalCnt-index: 남은 코어수 + 현재 코어수 < max
			return;
		}

		if (index == totalCnt) { // 모두 했을때
			if (max < cCnt) {
				max = cCnt;
				min = lCnt;
			} else if (max == cCnt) {
				if (min > lCnt) {
					min = lCnt;
				}
			}
			return;
		}

		int[] cur = list.get(index);
		int x = cur[0];
		int y = cur[1];
		for (int i = 0; i < 4; i++) {
			if (isAvailable(x, y, i)) {// 해당방향으로 가장자리까지 닿는지
				int len = setStatus(x, y, i, 2); // 2: 전선으로 채우기
				go(index + 1, cCnt + 1, lCnt + len);
				setStatus(x, y, i, 0); // 0: 빈칸으로 원복
			}
		}
		go(index + 1, cCnt, lCnt);
	}

	private static boolean isAvailable(int x, int y, int d) {
		int nx = x;
		int ny = y;
		while (true) {
			nx += dx[d];
			ny += dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				break; // 끝 도달시
			if (map[nx][ny] >= 1)
				return false; // 다른코어나 전선 만날시

		}

		return true;
	}

	private static int setStatus(int x, int y, int d, int s) {
		int nx = x, ny = y, cnt = 0;
		while (true) {
			nx += dx[d];
			ny += dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				break;
			map[nx][ny] = s;
			cnt++;
		}
		return cnt;
	}
}