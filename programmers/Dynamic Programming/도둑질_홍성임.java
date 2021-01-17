import java.util.*;

class Solution {
    public int solution(int[] money) {
        int length = money.length;
        int[][] array = new int[2][length];
        //첫번째 집 들리는 경우
        array[0][0] = money[0];
        array[0][1] = money[0];
        //첫번째 집 들리지 않는 경우
        array[1][0] = 0;
        array[1][1] = money[1];

        for(int i = 2; i < length; i++) {
            array[0][i] = Math.max(array[0][i-2] + money[i], array[0][i-1]);
            array[1][i] = Math.max(array[1][i-2] + money[i], array[1][i-1]);
        }

        return Math.max(array[0][array[0].length-2], array[1][array[1].length-1]);
    }
}
