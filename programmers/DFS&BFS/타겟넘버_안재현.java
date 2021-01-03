class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        int number = 0;
        int[] minusnum = new int[numbers.length];

        solution(target , 0 , 0 , numbers , numbers[0]);
        solution(target , 0 , 0 , numbers , numbers[0] * -1);
        return answer;
    }
    public void solution(int target , int i , int sum , int[] number , int num){
        if(i == number.length-1 ){// 마지막 값이면
            sum += num;
            if(sum == target)
                answer ++;
            return;
        }
        sum += num;
        solution(target , i+1 , sum , number , number[i+1]);
        solution(target , i+1 , sum , number , number[i+1] * -1);


    }
}
