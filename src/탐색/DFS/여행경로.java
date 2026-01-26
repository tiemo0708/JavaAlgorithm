package src.탐색.DFS;

import java.util.*;

public class 여행경로 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예제 1
        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(Arrays.toString(solution.solution(tickets1)));
        // 예상 출력: [ICN, JFK, HND, IAD]

        // 예제 2
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution.solution(tickets2)));
        // 예상 출력: [ICN, ATL, ICN, SFO, ATL, SFO]
    }
}

class Solution {
    List<String> path;     // 필드
    boolean[] used;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        path = new ArrayList<>();  // 초기화
        used = new boolean[tickets.length];  // 초기화

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        path.add("ICN");

        dfs("ICN", tickets, 0);

        return path.toArray(new String[0]);
    }

    private boolean dfs(String current, String[][] tickets, int use) {
        if (tickets.length == use) {
            return true;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                path.add(tickets[i][1]);

                if (dfs(tickets[i][1], tickets, use + 1)) {
                    return true;
                }

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }

        return false;
    }
}