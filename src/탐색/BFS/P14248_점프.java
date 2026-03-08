package src.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P14248_점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count =0;
        int n = Integer.parseInt(br.readLine());
        int[] ai = new int[n];
        boolean[] visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ai[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s-1);
        visited[s-1] = true;
        count++;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int left = cur - ai[cur];
            int right = cur + ai[cur];
            if(left>=0&& !visited[left]){
                queue.add(left);
                visited[left] = true;
                count++;
            }
            if(right<n&& !visited[right]){
                queue.add(right);
                visited[right] = true;
                count++;
            }

        }
        System.out.println(count);
    }

}
