package src.SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class P1244_최대상금 {
    static int exchangeCount;
    static int answer;
    static char[] numbers;
    static List<Set<String>> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            numbers = st.nextToken().toCharArray();
            exchangeCount = Integer.parseInt(st.nextToken());
            answer = 0;

            visited = new ArrayList<>();
            for (int i = 0; i <= exchangeCount; i++) {
                visited.add(new HashSet<>());
            }

            dfs(0);

            sb.append("#").append(testCase).append(" ").append(answer).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int depth) {
        String current = new String(numbers);

        // 같은 교환 횟수에서 같은 숫자 상태를 다시 탐색할 필요는 없다.
        if (visited.get(depth).contains(current)) {
            return;
        }
        visited.get(depth).add(current);

        if (depth == exchangeCount) {
            answer = Math.max(answer, Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                swap(i, j);
                dfs(depth + 1);
                swap(i, j);
            }
        }
    }

    static void swap(int first, int second) {
        char temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }
}
