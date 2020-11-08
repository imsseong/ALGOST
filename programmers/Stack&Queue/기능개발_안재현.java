//import java.util.*;
//
//
//public class prob_1 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] date = {7, 2 , 9};
//		List<Integer> k = new ArrayList<Integer>();
//		int cnt = 0;
//		while(true) {
//			int i = 0 , j = 0;
//			for( j = i ; j <date.length ; j++ ) {
//				if(date[i] >= date[j])
//					cnt +=1;
//				else {
//					k.add(cnt);
//					cnt = 1;
//					i = j;
//					break;
//					
//				}
//			}
//			if(i == date.length -1) {
//				System.out.println(i+" "+j);
//				System.out.println(cnt);
//				System.out.println("last");
//				k.add(cnt);
//				break;
//				}
//		}
//		
//		for(int i = 0 ; i < k.size() ; i++)
//			System.out.println(k.get(i));
//			
//
//	}
//}
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> date = new ArrayList<Integer>();
        int cnt = 0;
        int[] time = new int[progresses.length];
        for(int i = 0 ; i < progresses.length ; i++)
            time[i] = (int)Math.ceil((100-progresses[i])/speeds[i]);
        for(int i = 0 ; i <time.length ; i++)
            System.out.println(time[i]);

            for(int i = 0 ; i < time.length ; i++){
                for(int j = i ; j < time.length ; j++){
                    if(time[i] >= time[j]){
                        cnt++;
                }
                    else{
                    date.add(cnt);
                    i = j;
                    cnt = 1;
                    break;
                }
                if(i == (time.length)-1){
                    System.out.println("last");
                    date.add(cnt);
                    
                }
           }
            
        } 
        int[] answer = new int[date.size()];
        for(int i = 0 ; i < date.size() ; i++)
            answer[i] = date.get(i);
        return answer;
        
        
    }
}