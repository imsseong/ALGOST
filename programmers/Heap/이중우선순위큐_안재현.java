import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        ArrayList<Integer> list = new ArrayList();
        int[] answer = {};
        answer = new int[2];
        for(String s  : operations){
            char op = s.charAt(0);
            int num = Integer.parseInt(s.substring(2)); // 2번째 원소부터 마지막원소를 잘라서 Integer 형태로 변환
            System.out.println(num);
            if(op == 'I'){
                list.add(num);
                Collections.sort(list); // 오름차순 정렬
            }
            else if(op == 'D'){
                if(num == -1){ // 최솟값 삭제
                    if(list.isEmpty())
                        continue;
                    else{
                        list.remove(0); // 첫번째 값 삭제
                    }
                }
                else if(num == 1){ // 최댓값 삭제

                    if(list.isEmpty())
                        continue;
                    else{ //
                        list.remove(list.size()-1);
                    }
                }
            }

        }
        if(list.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;

        }
        else{
            answer[0] = list.get(list.size() - 1);
            answer[1] = list.get(0);
    }
        return answer;
    }
}
