import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                if(a[1]==b[1]){
                    return Integer.compare(a[2],b[2]);
                }
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        
        int maxTime =0;
        for(int a[] : jobs){
            int t =a[1]; //소요시간
            maxTime+=t;
//             int r = a[0]; //요청시점
         
//             pq.offer(new int[]{t,r,idx});//소요시간, 요청시점, 번호
//             idx++;
        }
        int idx =0;
        int rt =0;
        for(int time =0; time<=maxTime; time++){
              for(int a[] : jobs){
                 
                  if(a[0] == time){
                        //System.out.println(a[0]+" : "+time);
                      pq.offer(new int[]{a[1],a[0],idx});//소요시간, 요청시점, 번호
                      idx++;
                  }
              }
            
            while(!pq.isEmpty()){
                int a[] =pq.poll();
                
                if(rt<time){
                    rt = time;
                    System.out.println(time);
                }
                rt = rt + a[0];
                System.out.println(a[0]);
                answer+= rt - a[1];
                System.out.println(rt+" : "+ a[1]);
            }
        }
        return answer/jobs.length;
    }
}