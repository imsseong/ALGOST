import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String , Integer> map= new HashMap<String , Integer>();
        for(String v : participant){
            if(map.containsKey(v) == true) // 값이 있다면
                map.put(v , map.get(v) +1) ; // value 값에 +1
            else // 값이 없다면
                map.put(v , 1);
        }
        for(String v : completion){
            if(map.containsKey(v) == true) // completion 값이 map 에 존재한다면 -1
                map.put(v , map.get(v)-1);
        }
        for(String key : map.keySet()){
            if(map.get(key) == 1) //  key값으로 찾아서 그 value 가 1 이면 answer = key
                answer = key;
        }
        
        return answer;
    }
}