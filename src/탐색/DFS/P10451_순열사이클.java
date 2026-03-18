package src.탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10451_순열사이클 {
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int count = 0;
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < n+1; j++) {
                if (!visited[j]) {
                    count++;
                    dfs(j);
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int j) {
        if(!visited[j]){
            visited[j] = true;
            dfs(arr[j]);
        }
    }
}