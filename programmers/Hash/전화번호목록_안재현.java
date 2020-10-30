import java.util.Arrays;

public class 전화번호목록_안재현 {
	public static void main(String args[]) {
		String[] phonebook = new String[] {"119", "17674223" , "1175524421" , "1"};
		Arrays.sort(phonebook);
		for(String v : phonebook)
			System.out.println(v);
		for(int i = 0 ; i < phonebook.length ; i++){
			for(int j = i+1 ; j < phonebook.length ; j++)
				if(phonebook[j].startsWith(phonebook[i]))
					System.out.println("false");
			
		}
	}
	
}
