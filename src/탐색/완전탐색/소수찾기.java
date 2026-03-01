package src.탐색.완전탐색;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    public static void main(String[] args) {
        Solution42839 solution = new Solution42839();

        // 예제 1
        System.out.println(solution.solution("17"));
        // 예상 출력: 3

        // 예제 2
        System.out.println(solution.solution("011"));
        // 예상 출력: 2
    }
}

class Solution42839 {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        findS(numbers, "", visited, set);
        for (int num : set) {
            if (isPrime(num)) answer++;
        }

        return answer;
    }

    private boolean isPrime(int num) {
        if(num <2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    private void findS(String numbers, String current, boolean[] visited, Set<Integer> set) {
        if(!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }
        for(int i =0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                findS(numbers,current + numbers.charAt(i), visited, set);
                visited[i] = false;
            }
        }
    }
}