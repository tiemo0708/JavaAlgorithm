import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i =0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        System.out.println(map.size());
 
        int cnt =1;
        for(String key : map.keySet()){
        
            cnt *= map.get(key)+1;
        }
        answer = cnt -1;
        return answer;
    }
}