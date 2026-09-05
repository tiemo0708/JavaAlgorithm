import java.util.*;
class Solution {
    Map<String, List<String>> adjList = new HashMap<>(); //공항 인접 리스트
    Map<String, boolean[]> visited = new HashMap<>(); // 방문 체크
    String[] answer;
    int length;
    
    public String[] solution(String[][] tickets) {
        length = tickets.length + 1;
        // 1. 인접리스트 구성
        for(String[] ticket : tickets){
            String from = ticket[0];
            String to = ticket[1];
            adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }
        //2. 알파벳 순으로 정렬
        for(String key: adjList.keySet()){
            Collections.sort(adjList.get(key));
            visited.put(key, new boolean[adjList.get(key).size()]);
        }
        
        // 이동 경로 저장
        String[] path = new String[tickets.length+1];
        path[0] = "ICN";
        dfs(path,1,"ICN"); //경로. 인덱스, 출발지(키)
        
        return answer;
    }
    private boolean dfs(String[] path, int idx, String cur){
        if(idx==length){
            answer = Arrays.copyOf(path,idx);
            return true;
        }
        List<String> next =adjList.get(cur);
        if(next==null) return false;
        
        boolean[] used = visited.get(cur);
        for(int i=0; i< next.size(); i++){
            if(!used[i]){
                used[i] =true; //방문체크
                path[idx] = next.get(i);
                if(dfs(path, idx+1, next.get(i))){
                    return true;
                }
                 used[i] =false; //원복
            }
        }
        return false;
    }
}