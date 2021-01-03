class Solution {
    static int minnum = 51;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visit = new boolean[words.length];
        int cnt = 0;
        for(int i = 0 ; i < visit.length ; i++){
            if(diffone(begin ,words[i])){
                visit[i] = true;
                cnt ++;
                mysolution(words[i] , target , visit , cnt , words , i);
                //재귀 들어가기
                visit[i] = false;
                cnt --;
            }


        }

        if (minnum == 51) return 0;

        return minnum;

    }

    public void mysolution(String begin , String target , boolean[] visit , int cnt , String[] words , int index){
        if(begin.equals(target)){
            if(cnt < minnum)    minnum  = cnt;
            return;
        }
        if(index == visit.length - 1)
            return;
        for(int i = 0 ; i< words.length ; i++){
            if(diffone(begin ,words[i]) && visit[i] == false){ // 글자 하나 차이날경우
                visit[i] = true;
                cnt ++;
                mysolution(words[i] , target , visit , cnt , words , i);
                visit[i] = false;
                cnt --;
            }


        }
    }

    public boolean diffone(String word1 , String word2){
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int diff =0;
        for(int i = 0 ; i < w1.length ; i++)
            if(w1[i] != w2[i])  diff ++;

        if(diff == 1)   return true;
        else return false;


    }
}
