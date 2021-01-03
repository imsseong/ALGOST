class Solution {
    public static int dfs(int [] numbers,int target ,int index, int sum) {
		if(index == numbers.length) {
			if(target == sum) return 1;
			else return 0;
		}
		else {
			int a = dfs(numbers,target,index+1,sum+numbers[index]);
			int b = dfs(numbers,target,index+1,sum-numbers[index]);
			return a+b;
		}
	}
	public static int solution(int[] numbers, int target) {
	        return  dfs(numbers,target,0,0);
	    }
}
