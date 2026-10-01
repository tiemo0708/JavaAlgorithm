import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int n : nums){
            if(set.add(n)){
                answer++;
            }
            if(answer == (nums.length/2)){
                break;
            }
        }
        return answer;
    }
}