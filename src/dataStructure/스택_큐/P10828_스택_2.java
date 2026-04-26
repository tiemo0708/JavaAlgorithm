package src.dataStructure.스택_큐;

import java.io.*;
import java.util.*;

public class P10828_스택_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }else if (cmd.equals("pop")){
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            }else if(cmd.equals("top")){
                sb.append(stack.isEmpty() ? -1: stack.peek()).append("\n");
            }else if(cmd.equals("size")){
                sb.append(stack.size()).append("\n");
            }else if (cmd.equals("empty")) {
                sb.append(stack.isEmpty() ? 1: 0).append("\n");
            }
        }
        System.out.print(sb);
    }
}