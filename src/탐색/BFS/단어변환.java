package src.탐색.BFS;

import java.util.*;

public class 단어변환 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예제 1
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution.solution(begin1, target1, words1));
        // 예상 출력: 4

        // 예제 2
        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution.solution(begin2, target2, words2));
        // 예상 출력: 0 (cog가 words에 없음)
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];  // boolean[] 방식
        int depth = 0;
        queue.add(begin);
        while (!queue.isEmpty()) {
            int size = queue.size();  // 현재 레벨 크기

            // 현재 레벨의 모든 단어 처리
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // target 찾았는지 체크
                if (current.equals(target)) {
                    return depth;
                }

                for (int j = 0; j < words.length; j++) {
                    if (!visited[j] && canConvert(current, words[j])) {
                        visited[j] = true;
                        queue.add(words[j]);
                    }
                }
            }

            depth++;  // 한 레벨 완료
        }

        return 0;  // 못 찾으면 0
    }

    private boolean canConvert(String word1, String word2) {
        int count = 0;  // 다른 글자 개수

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }

        return count == 1;  // 정확히 1개만 달라야 true
    }

}