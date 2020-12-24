import java.util.Arrays;
class Solution {
  public static int solution(int[] people, int limit) {
        int answer = 0;
        int boat = 0;
        int left = 0;
        int right = people.length-1;
        Arrays.sort(people);
        while(true){
            if(right < left) break;
            boat = people[right--];
            while(boat+people[left]<= limit){
                boat+= people[left++];
            }
            answer++;
        }
        return answer;
    }
}
