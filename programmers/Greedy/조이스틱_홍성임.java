import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String name) {
        int size = name.length();

        int upDown = 0;
        for(int i = 0; i < size; i++) {
            upDown += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }

        int leftRight = name.length() - 1; //왼쪽 오른쪽 이동 횟수
        for (int i = 0, j; i < size; i++) {
            j = i + 1;
            while(j < size && name.charAt(j) == 'A') j++;
            if(name.charAt(i) == 'A' && j == size + 1) break;
            int right = (i * 2) + (size - j);
            int left = i + ((size - j) * 2);
            leftRight = Math.min(Math.min(left, right), leftRight);
		    }

        return upDown + leftRight;
    }
}
