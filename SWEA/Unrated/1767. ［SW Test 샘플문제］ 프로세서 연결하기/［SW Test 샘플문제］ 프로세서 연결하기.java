import java.io.*;
import java.util.*;

class Solution {
	static int n;
	static int[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static List<int[]> coreList;
	static int totalCnt;
	static int max, min;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n]; // 0:빈공간, 1:코어, 2:설치된 전선
			coreList = new ArrayList<>();
			max = 0;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (i == 0 || j == 0 || i == n - 1 || j == n - 1)
						continue;
					if (arr[i][j] == 1) coreList.add(new int[] { i, j }); // 코어의 좌표

				}

			}
			totalCnt = coreList.size(); // 가장자리가 아닌 코어 개수
			dfs(0, 0, 0);
			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	/*
	 * 최대한 많은 core연결, 최대 코어 개수가 같으면 전선길의 합이 최소
	 */

	// idx: 이번에 처리할 코어의 리스트 인덱스, cCnt: 현재까지 연결된 코어개수,lCnt: 연결된 코어 전선
	private static void dfs(int idx, int cCnt, int lCnt) {

		// 남은 코어
		int remaining = totalCnt - idx;

		// 남은 코어를 전부 연결해도 기존 최대 개수에 못미치면 중단
		if (cCnt + remaining < max) {
			return;
		}

		// 모든 코어의 연결여부를 결정했다면 정답비교
		if (idx == totalCnt) {
			// 더많은 코어를 연결하면 전선 길이와 상관 없이 새 정답
			if (cCnt > max) {
				max = cCnt;
				min = lCnt;
			} else if (cCnt == max) {
				// 연결 개수 같으면 더 짧은 전선 길이 선택
				min = Math.min(min, lCnt);
			}
			return;
		}

		// 코어처리
		int[] cur = coreList.get(idx);
		int cx = cur[0];
		int cy = cur[1];

		for (int d = 0; d < 4; d++) {
			if (isAvailable(cx, cy, d)) {

				// 해당 방향에 전선 설치, 설치한 길이 반환
				int len = setStatus(cx, cy, d, 2);

				// 현재 코어를 연결한 상태로 다음 코어 처리
				dfs(idx + 1, cCnt + 1, lCnt + len);

				// 전선 제거
				setStatus(cx, cy, d, 0);

			}
		}
		// 연결하지 않고 다음 코어 처리
		dfs(idx + 1, cCnt, lCnt);

	}

	// d 방향의 경로를 s로 채우고, 바꾼 칸 수를 반환
	// s = 2: 전선 설치
	// s = 0: 전선 제거
	private static int setStatus(int cx, int cy, int d, int s) {
		int nx = cx;
		int ny = cy;
		int cnt = 0;

		while (true) {
			// 코어 자기칸은 바꾸지 않고 옆칸부터 처리
			nx += dx[d];
			ny += dy[d];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
				break;
			}

			arr[nx][ny] = s;
			cnt++;

		}

		return cnt;
	}

	private static boolean isAvailable(int cx, int cy, int d) {
		int nx = cx;
		int ny = cy;

		while (true) {
			nx += dx[d];
			ny += dy[d];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
				break;
			}
			// 다른 코어나 이미 설치한 전선이 있으면 연결 불가
			if (arr[nx][ny] >= 1) {
				return false;
			}
		}

		return true;
	}

}
