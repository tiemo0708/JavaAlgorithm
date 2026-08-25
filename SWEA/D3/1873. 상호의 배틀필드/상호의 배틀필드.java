import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// 위 왼 아래 오
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char[][] arr = new char[h][w]; // 배틀필드
			int sx = 0, sy = 0; // 시작점

			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
						sx = i;
						sy = j;
					}
				}
			}

			int n = Integer.parseInt(br.readLine()); // 입력 개수
			String command = br.readLine(); // 명령

			// 명령 수행
			for (char c : command.toCharArray()) {
				if (c == 'U') {
					arr[sx][sy] = '^'; // 위 바라보기
					int nx = sx + dx[0];
					int ny = sy + dy[0];
					if (nx >= 0 && ny >= 0 && nx < h && ny < w && arr[nx][ny] == '.') { // 이동가능한지 확인
						arr[sx][sy] = '.'; // 현재위치를 평지로
						sx = nx;
						sy = ny;
						arr[sx][sy] = '^'; // 이동한 위치에 탱크 표시
					}

				} else if (c == 'D') {
					arr[sx][sy] = 'v';
					int nx = sx + dx[2];
					int ny = sy + dy[2];
					if (nx >= 0 && ny >= 0 && nx < h && ny < w && arr[nx][ny] == '.') { // 이동가능한지 확인
						arr[sx][sy] = '.'; // 현재위치를 평지로
						sx = nx;
						sy = ny;
						arr[sx][sy] = 'v'; // 이동한 위치에 탱크 표시
					}
				} else if (c == 'L') {
					arr[sx][sy] = '<';
					int nx = sx + dx[1];
					int ny = sy + dy[1];
					if (nx >= 0 && ny >= 0 && nx < h && ny < w && arr[nx][ny] == '.') { // 이동가능한지 확인
						arr[sx][sy] = '.'; // 현재위치를 평지로
						sx = nx;
						sy = ny;
						arr[sx][sy] = '<'; // 이동한 위치에 탱크 표시
					}
				} else if (c == 'R') {
					arr[sx][sy] = '>';
					int nx = sx + dx[3];
					int ny = sy + dy[3];
					if (nx >= 0 && ny >= 0 && nx < h && ny < w && arr[nx][ny] == '.') { // 이동가능한지 확인
						arr[sx][sy] = '.'; // 현재위치를 평지로
						sx = nx;
						sy = ny;
						arr[sx][sy] = '>'; // 이동한 위치에 탱크 표시
					}
				} else { // 포탄 발사
					if (arr[sx][sy] == '^') { // 위
						for (int i = sx; i >= 0; i--) {
							if (arr[i][sy] == '*') {
								arr[i][sy] = '.';
								break;
							} else if (arr[i][sy] == '#') {
								break;
							}
						}

					}
					if (arr[sx][sy] == 'v') { // 아래
						for (int i = sx; i < h; i++) {
							if (arr[i][sy] == '*') {
								arr[i][sy] = '.';
								break;
							} else if (arr[i][sy] == '#') {
								break;
							}
						}

					}
					if (arr[sx][sy] == '<') { // 왼
						for (int i = sy; i >= 0; i--) {
							if (arr[sx][i] == '*') {
								arr[sx][i] = '.';
								break;
							} else if (arr[sx][i] == '#') {
								break;
							}
						}

					}
					if (arr[sx][sy] == '>') { // 오
						for (int i = sy; i < w; i++) {
							if (arr[sx][i] == '*') {
								arr[sx][i] = '.';
								break;
							} else if (arr[sx][i] == '#') {
								break;
							}
						}

					}

				}
			}
			sb.append("#").append(test_case).append(" ");

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
