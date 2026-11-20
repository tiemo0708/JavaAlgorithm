import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] group;
	static int arr[];
	static int minDiff = Integer.MAX_VALUE;
	static List<List<Integer>> adj;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		 adj = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			for (int j = 0; j < idx; j++) {
				adj.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		group = new boolean[n+1];
		divide(1,0);
		if(minDiff==Integer.MAX_VALUE)minDiff = -1;
		System.out.println(minDiff);

	}

	static void divide(int idx, int countA) {// 배정할 구역번호, 넣은개수
		
		if(idx == n+1) {
			if(countA > 0 && countA<n) {
				evaluate(countA); // 완성된 배정 검사
			}
			return;
		}
		
		group[idx] = true;
		divide(idx+1, countA+1);
		
		group[idx] = false;
		divide(idx+1, countA);
	}

	private static void evaluate(int countA) {
		int countB = n- countA;
		
		int startA =0;
		int startB =0;
		int popA = 0;
		int popB =0;
		
		for(int i =1; i<=n; i++) {
			if(group[i]) { //A
				popA += arr[i];
				if(startA==0) startA =i;
			}else { //B
				popB += arr[i];
				if(startB==0) startB =i;
			}
		}
		
		 if (reachableCount(startA) != countA) return;
	     if (reachableCount(startB) != countB) return;
		
		minDiff = Math.min(minDiff, Math.abs(popA-popB));
		
	}

	private static int reachableCount(int start) {
		boolean[] visited = new boolean[n+1];
		Deque<Integer> queue = new ArrayDeque<>();
		
		queue.offer(start);
		visited[start] = true;
		int count =1; // 시작 구역 포함
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int next: adj.get(cur)) {
				if(!visited[next]&&group[next]==group[start]) {
					visited[next] = true;
					queue.offer(next);
					count ++;
				}
			}
		}
		
		
		return count;
	}
}
