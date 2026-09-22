import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] parent;

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 사람 수
            int M = Integer.parseInt(st.nextToken()); // 관계 수

            parent = new int[N + 1];

            // Make-Set
            // 처음에는 각자 혼자 하나의 집합
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            // 관계마다 Union
            for (int i = 0; i < M; i++) {

                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            // root 개수 = 무리의 개수
            int answer = 0;

            for (int i = 1; i <= N; i++) {

                // 자기 자신이 대표라면 하나의 무리
                if (find(i) == i) {
                    answer++;
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    // 대표(root) 찾기 + 경로 압축
    static int find(int x) {

        // 자기 자신이 부모면 root
        if (parent[x] == x) {
            return x;
        }

        // 경로 압축
        return parent[x] = find(parent[x]);
    }

    // 두 집합 합치기
    static void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        // 이미 같은 집합이면 합칠 필요 없음
        if (rootA == rootB) {
            return;
        }

        // b쪽 root를 a쪽 root 아래에 연결
        parent[rootB] = rootA;
    }
}