class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        int cnt = 0;
        int length = prices.length;
        answer = new int[length];
        for(int i = 0 ; i < length ; i++){
            for(int j = i+1 ; j < length ; j++){
                if(prices[i] <= prices[j])
                    cnt++;
                else{
                   cnt++;
                    break;
                }
            }
            answer[i] = cnt;
            cnt = 0;
            
        }      
        return answer;
    }
}