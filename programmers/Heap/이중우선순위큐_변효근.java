import java.util.Collections;
import java.util.ArrayList;
class Solution {
    public int[] solution(String[] operations) {

			int answer[] = new int[2];
				var list = new ArrayList<Integer>();
				for(String a : operations) {
					int idx = a.indexOf(" "); // 공백의 인덱스를 가져옴.
					String order = a.substring(0,idx); // 공백전까지 문자열을 order에 저장
					int num = Integer.parseInt(a.substring(idx+1));
          // 공백 이후의 문자를 integer형으로 변환 후 저장
					if(order.equals("I")) list.add(num);
          // I일 경우 list에 추가
					else if(order.equals("D")) {
						Collections.sort(list);
						if(num == 1 && list.size()!=0) list.remove(list.size()-1);
						else if(num == -1 && list.size()!=0) list.remove(0);
            // D일 경우 정렬 후
            // 1일 경우 최대값을 지움.
            // 1일 경우 최솟값을 지움.
					}
				}
				System.out.println(list);
				if(list.size()==0) { // 큐가 비어있을 경우
					answer[0]=0;
					answer[1]=0;
				}
				else {
					answer[0] = list.remove(list.size()-1);
					answer[1] = list.remove(0);
				}
        return answer;
    }
}
