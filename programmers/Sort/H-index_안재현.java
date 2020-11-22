import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int m = citations.length/2; // 오름차순 정렬 0 , 1 , 3 , 5, 6
        Arrays.sort(citations);
        for(int i = 0 ; i < citations.length ; i++)
        {
            int h = citations.length - i; //인용된 논문
            if(citations[i] >= h) // 0~i 까지 인용된 논문이 h번보다 많거나 같다면
            {   answer = h;
                break;
            }
        }
        return answer;
    }

}
