class Solution {
    public long solution(int n, int[] times) {
        int maxTime =0;
        
        for(int time:times){
            maxTime = Math.max(maxTime, time);
        }
        long left =1; // 탐색할 시간 범위의 최솟값
        
        // 가장 느린 심사관 한명이 모두 처리하는시간
        long right = (long) maxTime * n;
        long answer = right;
        while(left<=right){
            // 큰 두 수를 바로 더하지 않아서 오버플로를 방지
            long mid = left+(right-left)/2;
            
            // mid분 동안 처리할 수 있는 총 인원
            long count = 0;
            
            for(int time : times){
                count+= mid/time;
              if(count>=n){
                    break;
                }
            }
            if(count >=n){
                answer = mid;
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        
        return answer;
    }
}