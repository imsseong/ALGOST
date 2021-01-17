import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        while(k > 0) {
            int length = sb.length();
            int index = length - 1;
            for(int i = 0; i < length - 1; i++) {
                if(sb.charAt(i) < sb.charAt(i+1)) {
                    index = i;
                    break;
                }
            }
            sb.deleteCharAt(index);
            k--;
        }
        return sb.toString();
    }
}
