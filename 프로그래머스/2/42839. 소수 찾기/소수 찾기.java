import java.util.*;
class Solution {
    static boolean[] visited; //방문 체크
    static Set<Integer> numSet = new HashSet<>(); //중복 제거
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        dfs(numbers, 0, ""); // 숫자, 깊이, 현재조합
        
        for(int num: numSet){
            if(isPrime(num)){
                answer++;
            }
        }
        
        
        return answer;
    }
    
    static void dfs(String numbers, int depth, String current){
        if(depth>0){ // 모든 조합 저장
            numSet.add(Integer.parseInt(current));
        }
        
        for(int i=0; i< numbers.length(); i++){
            if(!visited[i]){ // 방문 하지 않았을때만
                visited[i] = true;
                dfs(numbers, depth+1, current+numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num){
        if(num<2) return false;
        for(int i = 2; (long)i*i<=num; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}