import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        //records 0[시간]. 1[차번호]
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> carFee = new HashMap<>();
        //List<Integer> carsort = new ArrayList<>();
        for(int i=0; i<records.length; i++){
            String[] str = records[i].split(" ");
            
            String carNum = str[1];
            String[] parts = str[0].split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int time = h*60+m;
            if(!map.containsKey(carNum)){
                map.put(carNum, time);
            }else{
                carFee.put(carNum,carFee.getOrDefault(carNum,0)+ time - map.get(carNum));
                map.remove(carNum); //출차처리
            }
        }
        //출차되지 않은것 처리
        for(String cn: map.keySet()){
            int time = 23*60+59;
             carFee.put(cn,carFee.getOrDefault(cn,0)+ time - map.get(cn));
        }
        //리스트에 넣기
        int[][] carSort = new int[carFee.size()][2];
        int idx =0;
         for(String cn: carFee.keySet()){
             carSort[idx][0] = Integer.parseInt(cn); //차번호
             carSort[idx][1] = carFee.get(cn);//사용시간
             idx++;
         }
        Arrays.sort(carSort,(a,b)->Integer.compare(a[0], b[0]));
        
        int[] answer = new int[carSort.length];
        for(int i=0; i<carSort.length; i++){
            
            int cartime = carSort[i][1];
            cartime = cartime - fees[0];
            int extraFee =0;
           if(cartime >0){
               int et = cartime / fees[2];
               extraFee = et*fees[3];
               if( cartime % fees[2]!=0){
                   extraFee+=fees[3];
               }
           }
            
            answer[i] = fees[1] + extraFee;
        }
        
        return answer;
    }
}