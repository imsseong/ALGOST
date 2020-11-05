import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        	ArrayList<Integer> answerlist = new ArrayList<>();
	        ArrayList<Integer> date = new ArrayList<>();
	        int [] answer ;
	        for(int i=0;i<progresses.length;i++){
	            float time = 100 - progresses[i];
	            date.add((int)Math.ceil(time/speeds[i]));
	        }
	        int count=0;
	        int base = -1;
	        int m = date.size();
	        for(int i=0;i<m;i++){
	            int day = date.remove(0);
	            System.out.println(day);

	            if(i==0){
	              base = day;
	              count=1;
	              continue;
	            }

	            if(base >= day ){
	              count++;
	            }
	            else {
	            	answerlist.add(count);
		            count = 1;
		            base = day;
	            }
	            if(i==m-1)
	            	answerlist.add(count);

	        }
	     	answer = new int [answerlist.size()];
	        for(int i=0;i<answerlist.size();i++) {
	    		answer[i] = answerlist.get(i);
	        }

        return answer;
    }
}
