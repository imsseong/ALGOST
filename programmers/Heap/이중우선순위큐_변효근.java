import java.util.Collections;
import java.util.ArrayList;
class Solution {
    public int[] solution(String[] operations) {

			int answer[] = new int[2];
				var list = new ArrayList<Integer>();
				for(String a : operations) {
					int idx = a.indexOf(" ");
					String order = a.substring(0,idx);
					int num = Integer.parseInt(a.substring(idx+1));
					if(order.equals("I")) list.add(num);
					else if(order.equals("D")) {
						Collections.sort(list);
						if(num == 1 && list.size()!=0) list.remove(list.size()-1);
						else if(num == -1 && list.size()!=0) list.remove(0);
					}
				}
				System.out.println(list);
				if(list.size()==0) {
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
