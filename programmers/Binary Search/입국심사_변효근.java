public static long solution(int n, int[] times) {
     long answer = 0;
     Arrays.sort(times);
     long sum = 0;
     long left = 1;
     long mid =0;
     long right = (long)times[times.length-1]*(long)n;
     long pre_sum = 0;
     long pre_mid=0;
     while(left<=right){
       sum = 0;
       mid = (left+right)/2;
       for(int i=0;i<times.length;i++) {
         sum+= mid/(long)times[i];        //총 몇명이 지나가는지를 계산.
       }
       System.out.println("mid: "+mid);
       System.out.println("sum: "+sum);
       if(pre_sum==sum && pre_mid == mid) break; // 만약 전 값과 이번 값이 같다면 break
       if((long)n<sum) right = mid;
       else if((long)n>sum) left = mid+1;
       else if((long)n==sum) break;
       pre_sum = sum;               //무한루프를 깨기 위한 변수 설정
       pre_mid = mid;               //무한루프를 깨기 위한 변수 설정
     }
     boolean idx = false;
     while(true) {                         // 7 10에 경우 답은 28이나 나눈 값을 비교해볼때 29또한 28과 같다.
       for(int i=0;i<times.length;i++) {   // 이경우를 위해 수를 빼면서 28로 맞춰준다.
         if(mid%(long)times[i]==0) idx = true;
       }
       if(idx == true) break;
       mid--;
     }

       return mid;
 }
