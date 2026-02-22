package src.탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16953_A에서B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Queue<Long> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();

        queue.add(A);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long cur = queue.poll();
                if (cur == B) {
                    System.out.println(depth + 1);
                    return;
                }

                    long next1 = cur * 2;
                if (!visited.contains(next1)&& next1 <= B) {
                    visited.add(next1);
                    queue.add(next1);
                    }
                    long next2 = cur * 10 + 1;
                if (!visited.contains(next2)&& next2 <= B) {
                    visited.add(next2);
                    queue.add(next2);
                }

            }
            depth++;
        }
        System.out.println(-1);
    }
}