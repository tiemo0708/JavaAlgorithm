import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 정지, 상, 우, 하, 좌
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };

	static int[][] APs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			int[] moveA = new int[m];
			int[] moveB = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			APs = new int[a][4];

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());

				APs[i][0] = Integer.parseInt(st.nextToken()) - 1;
				APs[i][1] = Integer.parseInt(st.nextToken()) - 1;
				APs[i][2] = Integer.parseInt(st.nextToken());
				APs[i][3] = Integer.parseInt(st.nextToken());
			}

			int ax = 0;
			int ay = 0;
			int bx = 9;
			int by = 9;

			// 이동 전 시작 위치에서도 충전
			int answer = charge(ax, ay, bx, by);

			for (int i = 0; i < m; i++) {
				ax += dx[moveA[i]];
				ay += dy[moveA[i]];

				bx += dx[moveB[i]];
				by += dy[moveB[i]];

				answer += charge(ax, ay, bx, by);
			}

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

	// 현재 위치에서 두 사람이 받을 수 있는 최대 충전량 합
	static int charge(int ax, int ay, int bx, int by) {
		int max = 0;

		// -1은 충전기를 사용하지 않는 경우
		for (int i = -1; i < APs.length; i++) {
			if (i != -1 && !canCharge(ax, ay, i)) {
				continue;
			}

			for (int j = -1; j < APs.length; j++) {
				if (j != -1 && !canCharge(bx, by, j)) {
					continue;
				}

				int sum = 0;

				if (i != -1) {
					sum += APs[i][3];
				}

				// 같은 충전기면 처리량을 한 번만 더함
				if (j != -1 && i != j) {
					sum += APs[j][3];
				}

				max = Math.max(max, sum);
			}
		}

		return max;
	}

	static boolean canCharge(int x, int y, int idx) {
		int distance = Math.abs(x - APs[idx][0]) + Math.abs(y - APs[idx][1]);

		return distance <= APs[idx][2];
	}
}