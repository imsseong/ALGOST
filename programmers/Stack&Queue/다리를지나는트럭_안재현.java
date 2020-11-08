import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truck_len = truck_weights.length;
        int weight_present = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int truck : truck_weights){
            while(true){
                if(bridge.isEmpty()){ // 다리위에 아무것도 없으면
                    bridge.add(truck);
                    weight_present += truck;
                    answer += 1;
                    break;
                }
                else if(bridge.size() == bridge_length){ // 꽉 차 있으면
                    weight_present -= bridge.poll();
                }
                else{
                    if(weight_present + truck <= weight ){ // 꽉 차지 않고 다음트럭 들어올 수 있음
                        bridge.add(truck);
                        weight_present += truck;
                        answer += 1;
                        break;
                    }
                    else // 꽉 차지않았지만 무게때문에 다음트럭 올 수 없음
                    {
                        answer += 1;
                        bridge.add(0);
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}