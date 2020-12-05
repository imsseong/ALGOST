import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;


	        Arrays.sort(citations);  // 정렬함.
	        int num = citations.length;
	        int H_index = citations[num-1]; // h-index를 배열 내 최대값으로 설정.

	        while(H_index!=0)
	        {
	            answer = 0;  // answer을 0으로 고정시킴
	            for(int i = num-1; i>=0;i--)
	            {
	                if(H_index <= citations[i])  answer++;
                  //h-index가 citations배열의 뒤부터 돌면서
                  //큰값이 있으면 answer을 1씩 추가 시킴
	                else break;
	            }
	            if(H_index == answer) break;
              // 위 조건은 모든 숫자가 같다면 안됨
              // 반례 2,2,2,2,2 => answer = 2 지만 위 방법에선 5가 나옴.
	            else if(H_index < answer ) {
	            	answer = H_index;
                // 조건 충족시 answer에 h-index를 넣고 break;
	            	break;
	            }
	            H_index--;

	        }
        return answer;
    }
}
