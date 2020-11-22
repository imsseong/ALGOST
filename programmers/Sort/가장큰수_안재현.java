import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] tmp = new String[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++)
            tmp[i] = Integer.toString(numbers[i]);

        Arrays.sort(tmp,new Comparator<String>(){
            @Override
            public int compare(String s1 , String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        for(String k : tmp)
            answer += k;
        if(answer.startsWith("0"))
            answer = "0";
        return answer;

    }
}

// 1의 자리수가 가장 큰 수가 앞으로가는것이 유리
// 10의자리 수 이상이면 1의자리수로 쪼개기
// reverseOrder 를 사용하게되면 3 과 30 을 비교할 때 30 이 먼저 나오게됨 , 그래서 330 과 303 중 303 을 택하게됨
