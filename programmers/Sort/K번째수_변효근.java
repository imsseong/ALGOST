import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int [] answer = new int[commands.length];
		 int t = commands.length;
		 int k = 0;
		 for(int[] a : commands)
	        {
	            int num = a[1]-a[0]+1;
	            int [] sorted = new int[num];
	            int j = 0;
	            for(int i = a[0]-1 ; i < a[1] ;i++,j++)
	            {
	            	sorted[j] = array[i];
	            }

	            Arrays.sort(sorted);

	            answer[k] = sorted[a[2]-1];
	            k++;

	        }
        return answer;
    }
}
