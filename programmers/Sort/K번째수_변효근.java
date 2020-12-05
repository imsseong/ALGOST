import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
     int [] answer = new int[commands.length];
		 int t = commands.length;
		 int k = 0;
		 for(int[] a : commands)
	        {
	            int num = a[1]-a[0]+1;
              //comands의 2중배열 중 첫번째(시작인덱스), 두번째(끝인덱스)를 가져옴
	            int [] sorted = new int[num];
              // 시작인덱스와 끝인덱스를 뺀 값 크기만큼의 배열을 새로만듬.
	            int j = 0;
	            for(int i = a[0]-1 ; i < a[1] ;i++,j++)
	            {
	            	sorted[j] = array[i];
                // 새로운 배열에 값들을 저장
	            }

	            Arrays.sort(sorted);
              // 배열을 정렬함.
	            answer[k++] = sorted[a[2]-1];
              // k값을 정함.
	        }
        return answer;
    }
}
