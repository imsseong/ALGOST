class Solution {
    public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];
		int total = brown + yellow; // 총 타일의 개수를 구함
		int x = 3;
    // 세로 타일의 수 -> 3으로 초기값을 설정 한 이유는 최소 3줄이 되어야
    // 노랑 타일이 생성가능.
		int y = 0;
		while(true) {
			if(total%x==0) {
        // 가로타일의 개수를 찾기위해
        // 총 타일에서 세로 타일을 나눔
				y=total/x;
				break;
			}
			x++;
      // x를 점차 늘리면서 검사함.
			if(x>total) break;
		}
      while(x <= y) { // 문제에서 가로길이는 세로길이와 같거나 세로길이보다 길다했으므로
			if(y*x == total && (y-2)*(x-2)==yellow) {
        // x,y를 곱해서 타일의 개수가 맞다면
        // 총 타일의 개수가 24개 일 경우
        // 3*8 , 4*6 의 경우의 수가 나옴.
        // 이를 위해 x값을 늘리면서 확인함.
				answer[0]=y;
				answer[1]=x;
			}
			x++;
			y=total/x;
		    }

        return answer;
    }
}
