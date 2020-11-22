import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        

	        Arrays.sort(citations);
	        int num = citations.length;
	        int H_index = citations[num-1];

	        while(H_index!=0)
	        {
	            answer = 0;
	            for(int i = num-1; i>=0;i--)
	            {
	                if(H_index <= citations[i])  answer++;
	                else break;
	            }
	            if(H_index == answer) break;
	            else if(H_index < answer ) {
	            	answer = H_index;
	            	break;
	            }
	            H_index--;

	        }
        return answer;
    }
}
