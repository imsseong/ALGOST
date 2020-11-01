package Algorithm;

import java.util.HashMap;

public class 위장_변효근 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 1;
        HashMap <String,Integer> A = new HashMap<String, Integer>();
        String[][] clothes = {{"yellow_hat","headgear"}, {"blue_sunglasses", "eyewear"}, 
        		{"green_turban","headgear"}};
        for(int i = 0; i<clothes.length ; i++)
        {
            A.put(clothes[i][1], A.getOrDefault(clothes[i][1],0)+1);   
        }
        for(int num : A.values())
        {
            answer *= (num+1);
        }
        System.out.println(answer-1);
    }
}
