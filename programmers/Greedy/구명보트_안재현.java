import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {

        int answer = 0;
        int tmp = 0;
        Arrays.sort(people);
//         int pt = 0;
//         while(true){
//             if(tmp == 0 && pt == people.length -1) // 한개남았을때
//             {
//                 answer += 1;
//                 break;
//             }
//             tmp += people[pt];
//             if(tmp <= limit){
//                 pt +=1;
//             }
//             else{
//                 tmp = 0;
//                 answer += 1;
//             }
//         }
        int i = 0;
        int j = people.length -1;
        while(i <=j){
            if(people[i] + people[j] > limit){
                answer +=1 ;
                j--;
            }
            else{
                answer +=1;
                i++;
                j--;
            }
        }
        return answer ;
    }
}
