package src.dataStructure.스택_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164_카드_큐 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = scanner.nextInt();
        for(int i=1; i<= N; i++){
            myQueue.add(i);
        }

        while(myQueue.size() > 1){
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }
        System.out.println(myQueue.poll());
    }

}
