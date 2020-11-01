import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String , Integer> Hash = new HashMap<>();
        
        for(int i = 0 ; i < clothes.length ; i++)
            Hash.put(clothes[i][1] , Hash.getOrDefault(clothes[i][1] , 0) + 1);
        for(Integer value : Hash.values())
            answer *= (value + 1) ; 
        return answer - 1;
    }
}