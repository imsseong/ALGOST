import java.util.PriorityQueue;
class Solution {
    public int Calculation(int a,int b)
    { // 스코빌 지수를 얻는 함수
        int max,min;
        if(a>=b)
        {
            max = a;
            min = b;
        }
        else
        {
            max = b;
            min = a;
        }
        // a,b중에 더 큰 숫자를 찾고
        // 제공된 공식을 사용하여
        // 스코빌 지수를 얻음.
        return min+(max*2);
    }
    public int solution(int[] scoville, int K)
    {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int aScoville : scoville) {
            heap.offer(aScoville);
            // heap에 정렬된 순서로 삽입.
        }
        for(int i=0;i<scoville.length;i++)
        {
            if(heap.size()==1)
            {
                int t = heap.poll();
                if(t >=K) // 조건 충족시
                    return answer;
                else
                    return -1;
            }
            int a = heap.poll(); //heap에서 맨 앞 숫자를 가져옴.
            int b = heap.poll(); //heap에서 2번째 숫자를 가져옴.
            if(a>=K && b>=K)
                break;
            int num = Calculation(a,b); // 스코빌 지수 계산
            heap.offer(num); // 그 지수를 다시 삽입
            answer++;
        }
        return answer;
    }
}
