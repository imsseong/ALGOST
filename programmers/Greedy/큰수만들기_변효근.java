class Solution {
    public static String solution(String number, int k) {
	    String answer = "";
	    char max = '0';
	    int index = -1;
	    for(int i=number.length()-k; i>0 ;i--) {
	    	max = '0';
	    	index = 0;

        // 맨 앞에서부터 k만큼의 수 중 가장 큰 수를 찾음.
        // 그 이후 숫자들 중에서도 나머지를 찾아

	    	for(int j = 0 ; j<number.length() -i+1 ;j++) {
		    	if(number.charAt(j)>max) {
		    		max = number.charAt(j);
		    		index = j;
		    	}
		    }
	    	number = number.substring(index+1);
	    	answer+=max;
	    }

	    return answer;
	}
}
