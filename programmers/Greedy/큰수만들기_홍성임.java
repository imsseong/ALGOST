import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        List<Integer> numList = Arrays.stream(number.split("")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        int minNum = numList.get(0);
        int count = 0;
        int index = 0;
        int temp = 0;

        for(int i = 0; i < numList.size(); i++) {
            if(count == k) {
                break;
            }
            System.out.println("minNum" +  minNum);

            if(minNum < numList.get(i) && temp < k) {
                System.out.println("minNum" + minNum);
                System.out.println("numList.get(i)" +  numList.get(i));
                numList.remove(index);
                minNum = numList.get(index);
                count++;
                temp = count;
                continue;
            } else {
                minNum = numList.get(index);
            }

            temp++;
        }

        return numList.stream().map(s -> String.valueOf(s)).collect(Collectors.joining());
    }
}
