import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;

        // [요청 시각, 소요 시간, 원래 작업 번호]
        int[][] sorted = new int[n][3];
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[]{jobs[i][0], jobs[i][1], i};
        }

        Arrays.sort(sorted,(a,b)->Integer.compare(a[0], b[0]));

        // [소요 시간, 요청 시각, 원래 작업 번호]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        int time = 0;
        int next = 0;       // 아직 큐에 넣지 않은 작업의 위치
        int completed = 0;
        int total = 0;

        while (completed < n) {
            // 현재 시각까지 요청된 작업을 모두 대기 큐에 넣기
            while (next < n && sorted[next][0] <= time) {
                pq.offer(new int[]{
                    sorted[next][1], sorted[next][0], sorted[next][2]
                });
                next++;
            }

            if (pq.isEmpty()) {
                // 대기 작업이 없다면 다음 요청 시각까지 이동
                time = sorted[next][0];
                continue;
            }

            // 한 작업만 실행하고, 완료 시각에 다시 요청들을 확인
            int[] job = pq.poll();
            time += job[0];
            total += time - job[1];
            completed++;
        }

        return total / n;
    }
}