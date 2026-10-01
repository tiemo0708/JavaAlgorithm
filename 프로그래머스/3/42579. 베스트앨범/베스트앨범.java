import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, List<Integer>> songs = new HashMap<>();
        for(int i =0; i<genres.length; i++){
            String genre = genres[i];
            map.put(genre, map.getOrDefault(genre,0)+plays[i]);
            
            if(!songs.containsKey(genre)){
                songs.put(genre, new ArrayList<>());
            }
            songs.get(genre).add(i);
        }
        // 장르 이름을 리스트로 옮겨 재생횟수로 내림차순 정렬
        List<String> genreList = new ArrayList<>(map.keySet());
        genreList.sort((a,b)->Integer.compare(map.get(b), map.get(a)));
        
        ArrayList<Integer> result = new ArrayList<>();
        for(String genre: genreList){
            List<Integer> songList = songs.get(genre);
            
            //해당 장르 노래 정렬
            songList.sort((a,b) -> {
                if(plays[a]==plays[b]){
                    return Integer.compare(a,b);
                }
                return Integer.compare(plays[b],plays[a]);
            });
            // 앞에서 두곡 선택
            for(int i=0; i< Math.min(2,songList.size()); i++){
                result.add(songList.get(i));
            }
        }
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}