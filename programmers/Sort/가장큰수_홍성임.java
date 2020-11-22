import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        if(Arrays.stream(numbers).allMatch(s -> s == 0)) return "0";
        return Arrays.stream(numbers)
            .mapToObj(s -> String.valueOf(s))
            .sorted((s1, s2) -> {
                return (s2 + s1).compareTo(s1 + s2);
            })
            .collect(Collectors.joining()); 
    }
}
