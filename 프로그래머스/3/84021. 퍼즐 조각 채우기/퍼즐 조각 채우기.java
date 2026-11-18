import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        // 1. 빈 공간 추출 (0)
        List<List<int[]>> emptySpaces = extract(game_board, 0);
        
         // 2. 퍼즐 조각 추출 (1)
        List<List<int[]>> pieces = extract(table, 1);
        
        boolean[] used = new boolean[pieces.size()];

        
        // 3. 빈 공간만다 들어갈 퍼즐 찾기
        for(List<int[]> empty: emptySpaces){
            for(int i=0; i< pieces.size(); i++){
                if(used[i]) continue;
                
                List<int[]> piece = pieces.get(i);
                
                //칸수가 다르면 비교 X
                if(empty.size()!=piece.size()) continue;
                
                List<int[]> rotated = piece;
                boolean matched = false;
                
                //4가지 방향비교
                for(int r =0; r<4; r++){
                  if (isSame(empty, rotated)) {
                        matched = true;
                        break;
                    }
                    rotated = rotate(rotated);
                }
                // 5. 일치하면 정답에 추가
                if (matched) {
                    used[i] = true;
                    answer += empty.size();
                    break;
                }
            }
        }
        
        
        return answer;
    }
    
    // 배열 전체에서 연결된 모양 추출
    static List<List<int[]>> extract(int[][] board, int target){
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        
        List<List<int[]>> shapes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==target&&!visited[i][j]){
                    List<int[]> shape = bfs(board, visited, i, j, target);
                    shapes.add(normalize(shape));
                }
            }
        }   
           return shapes;
    }
    
    //BFS로 연결된 좌표 추출
     static List<int[]> bfs(int[][] board, boolean[][] visited,
                           int x, int y, int target) {
         int n = board.length;
         
         Deque<int[]> queue = new ArrayDeque<>();
         List<int[]> shape = new ArrayList<>();
         
         queue.offer(new int[]{x, y});
         visited[x][y] = true;
         
         while(!queue.isEmpty()){
             
             int[] current = queue.poll();
             int cx = current[0];
             int cy = current[1];
             
             shape.add(new int[]{cx, cy});
             
             for(int d=0; d<4; d++){
                 int nx = cx + dx[d];
                 int ny = cy + dy[d];
                 
                 if(nx<0 || ny<0 || nx>=n || ny>= n || visited[nx][ny] || board[nx][ny]!=target) continue;
                 visited[nx][ny] = true;
                 queue.offer(new int[]{nx, ny});
             }
         }
         return shape;
         
     }
    
    // 좌표 정규화
    static List<int[]> normalize(List<int[]> shape){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int[] pos : shape){
            minX = Math.min(minX, pos[0]);
            minY = Math.min(minY, pos[1]);
        }
        
        List<int[]> result = new ArrayList<>();
        
        for(int[] pos : shape){
            result.add(new int[]{pos[0]-minX, pos[1]-minY});
        }
        
        //좌표를 행, 열 순서로 정렬
        result.sort((a, b) ->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        return result;
    }
    
    //모양비교
    static boolean isSame(List<int[]> a, List<int[]> b){
        if(a.size() != b.size())  return false;
        
        for(int i =0; i<a.size(); i++){
            if(a.get(i)[0]!=b.get(i)[0] || a.get(i)[1]!=b.get(i)[1]){
                return false;
            }
        }
        return true;
    }
    // 90도 회전
    static List<int[]> rotate(List<int[]> shape){
        
        List<int[]> rotated = new ArrayList<>();
        
        for(int[] pos: shape){
            int x = pos[0];
            int y = pos[1];
            rotated.add(new int[]{y, -x});
        }
        return normalize(rotated);
    }
}