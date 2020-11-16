import java.util.PriorityQueue;
class Solution {
    public int Calculation(int a,int b)
    {
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
        return min+(max*2);
    }
    public int solution(int[] scoville, int K)
    {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int aScoville : scoville) {
            heap.offer(aScoville);
        }
        for(int i=0;i<scoville.length;i++)
        {
            if(heap.size()==1)
            {
                int t = heap.poll();
                if(t >=K)
                    return answer;
                else
                    return -1;
            }
            int a = heap.poll();
            int b = heap.poll();
            if(a>=K && b>=K)
                break;
            int num = Calculation(a,b);
            heap.offer(num);
            answer++;
        }
        return answer;
    }
}
