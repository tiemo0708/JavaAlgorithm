class Solution {
    static int[] numbers;
    static int r;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        int answer = 0;
        r=0;
        dfs(target, 0, 0); //타겟, sum, count
        answer = r;
        return answer;
    }
    static void dfs(int target, int sum, int count){
        
        if(count==numbers.length){
            if(sum == target){
                r++;
            }
            return;
        }
        dfs(target, sum + numbers[count], count+1);
        dfs(target, sum - numbers[count], count+1);
    }
}