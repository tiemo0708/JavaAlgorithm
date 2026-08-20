import java.util.*;

class Solution {
	Map<String, List<String>> adjList = new HashMap<>();
	Map<String, boolean[]> visited = new HashMap<>();
	List<String> answer;

	public String[] solution(String[][] tickets) {

		// 인접리스트 구성 + 정렬
		for (String[] ticket : tickets) {
			String from = ticket[0];
			String to = ticket[1];

			adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);

			for (String key : adjList.keySet()) {
				Collections.sort(adjList.get(key)); // 정렬
				visited.put(key, new boolean[adjList.get(key).size()]);
			}

			List<String> path = new ArrayList<>(); // 방문 공항
			path.add("ICN");
			dfs(path, "ICN", tickets.length + 1); // 방문공항누적, 현재위치, 최대개수

		}

		return answer.toArray(new String[0]);
	}

	private boolean dfs(List<String> path, String cur, int total) {
		if (path.size() == total) {
			answer = new ArrayList<>(path);
			return true;
		}
		List<String> next = adjList.get(cur);
		if (next == null) {
			return false;
		}
		boolean[] used = visited.get(cur);
		for (int i = 0; i < next.size(); i++) {
			if (!used[i]) {
				used[i] = true;

				path.add(next.get(i));

				if (dfs(path, next.get(i), total))
					return true; // 성공하면 바로 리턴

				path.remove(path.size() - 1);

				used[i] = false;
			}
		}
		return false;

	}
}