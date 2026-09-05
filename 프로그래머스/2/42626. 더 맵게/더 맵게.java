import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        while(!pq.isEmpty()){
            int a = pq.poll();
            if(a>=K) break; //최소값이 k 이상이면 종료
            if(pq.isEmpty()) return -1; //더할 값이 없으면 -1 리턴
            int b = pq.poll();
            pq.offer(a+(b*2));
            answer++;
        }
        
        return answer;
    }
}