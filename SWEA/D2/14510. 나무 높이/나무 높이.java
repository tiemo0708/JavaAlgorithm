import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            
        	int N = Integer.parseInt(br.readLine());
        	int []arr = new int[N];
        	StringTokenizer st= new StringTokenizer(br.readLine());
        	
        	int maxheight = 0;
        	for(int i =0; i<N; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        		maxheight = Math.max(maxheight, arr[i]);
        	}
        	
        	int sum = 0;
        	int oddcnt = 0;
        	
        	for(int i=0; i<N; i++) {
        		
        		
        		int dif = maxheight - arr[i];
        		sum += dif;
        		if(dif % 2 == 1) {
        			oddcnt++;
        		}
        	}
        	
        	int days =(sum/3) *2 +(sum %3);
        	
        	int odddays = (days+1) /2;
        	
        	if(odddays <oddcnt) {
        		
        		days = (oddcnt)*2-1;
        	}
        	
        	
        	System.out.println("#" + tc +" "+days);
        }


    }
}
