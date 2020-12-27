class Solution {
    public int solution(int[][] triangle) {
          int answer = 0;
          for(int i = triangle.length-1 ; i>0; i--) {
          // 아래서부터 거슬러 올라감.
          // 경우의 수를 구할 경우 같은 부모에서 나올 수 있는 수의 경우의 수는 2가지
          // ex) 부모가 1이고 자식이 2,3일 경우 경우의 수는 3,4 이다.
          // 즉 자식이 더 큰 애가 더 큰 경우의 수를 가질 것.
        	int arr[] = triangle[i];
        	for(int j=0;j<triangle[i-1].length;j++) {
            // 자식 들을 비교하고 더 큰 값을 부모의 값과 더함.
            // 이렇게하면 나올 수 있는 경우의 수 2가지가 1가지로 줄어듬.
        		if(arr[j]<arr[j+1]) triangle[i-1][j]+=arr[j+1];
        		else triangle[i-1][j]+=arr[j];
        	}
        }
        answer+=triangle[0][0];
        return answer;
      }
}
