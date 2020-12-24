import java.util.*;

class Solution {
    public int solution(String name) {

        return Updown(name) + LeftRight(name);
    }
    private int Updown(String name){
        int num = 0;
        for(int i = 0 ; i < name.length() ; i++)
            num += Math.min(name.charAt(i) - 'A' , 'Z' - name.charAt(i) + 1);
        return num;
    }
    private int LeftRight(String name){
        int len = name.length();

        int move = name.length() - 1; // 오른쪽 으로만 갔을 떄
        for(int i = 0  , j ; i < len ; i++){
            j = i+1;
            while(j < len && name.charAt(j) == 'A') j++; // 제일 끝에있는 마지막 A가 아닌곳 찾기
            if(name.charAt(i) == 'A' && j >= len) break; // A가 아닌 지점 찾기 실패 i 는 A가 아니어야하고 j 도 size 보다 크거나같으면 안됨
            int right = (i*2) + (len - j); // 0부터 i 까지 갔다가 돌아오는 i *2 와 0에서 j로 가는길
            int left = i+ ((len - j) * 2); // 왼쪽으로 0부터 j까지 갔다가 돌아오는 것과 + i까지 가는 횟수
            move = Math.min(Math.min(left , right) , move);
        }
        return move;
    }

}
