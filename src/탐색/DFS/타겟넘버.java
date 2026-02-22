package src.탐색.DFS;

public class 타겟넘버 {
    public static void main(String[] args) {
        Solution43165 solution = new Solution43165();

        // 예제 1
        int[] numbers1 = {1, 1, 1, 1, 1};
        System.out.println(solution.solution(numbers1, 3));
        // 예상 출력: 5

        // 예제 2
        int[] numbers2 = {4, 1, 2, 1};
        System.out.println(solution.solution(numbers2, 4));
        // 예상 출력: 2
    }
}

class Solution43165 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
         answer = 0;
        // 여기에 풀이 작성
        dfs(numbers, 0, 0, target);

        return answer;
    }

    private void dfs(int[] numbers, int depth, int sum, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }

            dfs(numbers, depth + 1, sum + numbers[depth], target);
            dfs(numbers, depth + 1,  sum - numbers[depth], target);
    }
}