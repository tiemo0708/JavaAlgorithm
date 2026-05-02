package src.dataStructure.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i =0; i <n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")){
                queue.offer(Integer.parseInt(st.nextToken()));
            } else if(cmd.equals("pop")){
                sb.append(queue.isEmpty() ? -1: queue.poll()).append("\n");
            } else if(cmd.equals("front")){
                sb.append(queue.isEmpty() ? -1: queue.peek()).append("\n");
            } else if(cmd.equals(("size"))){
                sb.append(queue.size()).append("\n");
            } else if(cmd.equals("empty")){
                sb.append(queue.isEmpty() ? 1: 0).append("\n");
            } else if(cmd.equals("back")){
                sb.append(queue.isEmpty() ? -1: queue.peekLast()).append("\n");
            }

        }
        System.out.print(sb);
    }
}
