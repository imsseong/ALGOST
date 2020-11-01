package Algorithm;

import java.util.HashMap;

public class 완주하지못한선수_변효근 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"leo","kiki","eden"};
		String[] completion = {"kiki","eden"};
		
		HashMap<String , Integer> hash = new HashMap<String,Integer>();
		
		for(String a : participant) {
			if(hash.get(a)==null) hash.put(a, 1);
			else hash.put(a , hash.get(a)+1);
		}
		for(String b : completion) {
			hash.put(b , hash.get(b)-1);
		}
		for(String key : hash.keySet()) {
			if(hash.get(key)==1) System.out.println(key);
		}


	}

}
