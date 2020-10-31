import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothesMap = new HashMap<>();

        for(String[] cloth : clothes) {
            Integer val = clothesMap.get(cloth[1]);
            if(val != null) {
                clothesMap.put(cloth[1], val+1);
            } else {
                clothesMap.put(cloth[1], 1);
            }
        }

        for(Integer value : clothesMap.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }
}
