import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        //참가자 이름별 인원수 저장
        for(String name : participant){
            map.put(name, map.getOrDefault(name,0)+1);
        }
        // 완주한 사람 빼기
        for(String name: completion){
            map.put(name, map.get(name)-1);
        }
        
        for(String name: map.keySet()){
            if(map.get(name) == 1){
                answer = name;
            }
        }
     
        return answer;
    }
}