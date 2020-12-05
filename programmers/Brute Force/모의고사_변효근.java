import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
       ArrayList<Integer> abc = new ArrayList<Integer>();
	        int num = answers.length;

          int[] a_sample = {1, 2, 3, 4, 5};
          // 1번 수포자의 패턴

          int[] b_sample = {2, 1, 2, 3, 2, 4, 2, 5};
          // 2번 수포자의 패턴

          int[] c_sample = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
          // 3번 수포자의 패턴

          int a_count = 0;
	        int b_count = 0;
	        int c_count = 0;
          // 수포자의 맞은 개수를 체크할 변수들

	        for(int i=0;i<num;i++)
	        {
	            if(a_sample[i%5]==answers[i])a_count++;
	            if(b_sample[i%8]==answers[i])b_count++;
	            if(c_sample[i%10]==answers[i])c_count++;
              // 나머지값을 이용하여 수포자의 패턴에 맞춤
              // 12번 문제의 경우
              // 1번 수포자는 12%5 = 2이므로 5개의 답 패턴 중 2번째 값임.
              // 2번 수포자는 12%8 = 5이므로 8개의 답 패턴 중 5번째 값임.
              // 3번 수포자는 12%10 = 2이므로 10개의 답 패턴 중 2번째 값임.
	        }
	        int[] count = {a_count,b_count,c_count};
	        Arrays.sort(count);
	        int top = count[2];
	        if(a_count==top) abc.add(1);
	        if(b_count==top) abc.add(2);
	        if(c_count==top) abc.add(3);
	        int[] answer = new int[abc.size()];
	        for(int i=0;i<abc.size();i++)
	            answer[i] = abc.get(i);
          //값을 비교하고 형식에 맞추기 위하여
          //계산함.
        return answer;
    }
}
