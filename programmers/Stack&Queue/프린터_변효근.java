import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
            int answer = 0;
	        int count = 0;
			Queue <Integer> q = new LinkedList<Integer>();
			for(int i : priorities)
				q.add(i);           // Queue에 대입
			count = q.size();       // q size가 바뀌므로
			for(;count!=0;)
			{
				int a = q.poll();
	            if(q.size()==0)
				{
					answer+=1;
					return answer;
				}
				if(a<Collections.max(q))
				{
					q.add(a);
					if(location==0) location = q.size()-1;
					else location-=1;
				}
				else
				{
					count-=1;
					location-=1;
					answer+=1;
					if(location==-1)
					{
						return answer;
					}
				}
	        }
        return 0;
    }
}
