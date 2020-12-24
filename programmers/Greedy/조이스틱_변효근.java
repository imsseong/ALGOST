class Solution {
    public static int check(char target) { //상하로 움직이는 움직임을 계산
		 int answer=100;
		 System.out.println(target);
		 if(target-'A'<=answer){ answer = target-'A';}
     //A에서 가는것이 더 가깝다면 그 값을 answer에 저장
		 if(Math.abs(target-'Z')+1<=answer) { answer = Math.abs(target-'Z')+1;}
     //Z에서 가는것이 더 가깝다면 그 값을 answer에 저장
		 return answer;
	}
	 public static int solution(String name) {
	        int answer = 0;
	        int [] arr = new int[name.length()];
	        for(int i=0;i<name.length();i++) {
	        	arr[i] = check(name.charAt(i));
	        	answer+=arr[i];
	        }
          // 양 끝에서 오른쪽을 들렸다가 왼쪽으로 갈지
          // 왼쪽을 들렸다 오른쪽을 갈지를 결정하기 위해
          // 어느쪽이 더 끝에서 가까운지를 결정
          // BBAAAAAB 의 경우 오른쪽을 들렷다가 왼쪽에서 끝을 냄
          // BBAAABBBB의 경우 왼쪽을 들렸다가 오른쪽에서 끝을 냄
	        int left = 0;
	        for(int i=0;i<name.length()/2;i++) {
	        	if(arr[i]==0) continue;
	        	left = i;
	        }
	        left+=1;
	        int right =0;
	        for(int i=name.length()-1;i>=name.length()/2;i--) {
	        	if(arr[i]==0) continue;
	        	right  = i;
	        }
	        right = name.length()-right;
	        int sum = 0;
	        if(left>right) {
	        	sum+= right*2;
	        	sum+= left-1;
	        }
	        else {
	        	sum+= (left-1)*2;
	        	sum+= right;
	        }
	        if(sum>name.length()-1) answer += name.length()-1;
	        else answer+=sum;
	        return answer;
	    }
}
