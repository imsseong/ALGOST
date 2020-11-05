class Solution {
    public int[] solution(int[] prices) {
        int m = prices.length;
        int[] answer = new int[m];
        int count = 0;
        for(int i = 0 ; i < m ; i++)
        {
            count = 0;
            for(int j = i+1 ; j < m ; j++)
            {
                if( prices[i] <= prices[j])
                    count++;
                else
                {
                    count++;
                    break;
                }
            }
            answer[i]=count;
        }
        return answer;
    }
}
