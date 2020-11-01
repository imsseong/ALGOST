package Algorithm;

import java.util.HashMap;

public class 전화번호목록_변효근 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = {"12", "123", "1235", "567", "88"};
		boolean answer = true;
		boolean index = false;
		HashMap <String,Integer> hash = new HashMap <String,Integer>();
		
		for(String a : phone_book) {
			hash.put(a,0);
		}	
		for(String a : hash.keySet()) {
			for(String b : hash.keySet()) {
				System.out.println("b: " + b);
				if(b.startsWith(a))
                {
				    answer = false;
                    index = true;
                    break;
                }
			}
			if(index==true) break;
		}
		System.out.println(answer);
	}

}
