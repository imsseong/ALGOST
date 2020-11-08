import java.util.*;

class Solution {
    class Truck {
        int enter_time;
        int weight;

        public Truck(int enter_time, int weight) {
            this.enter_time = enter_time;
            this.weight = weight;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int total_weight = 0;
        Queue<Truck> waiting_truck = new LinkedList<>();
        Queue<Truck> on_bridge_truck = new LinkedList<>();

        for(int truck_weight : truck_weights) {
            waiting_truck.offer(new Truck(0, truck_weight));
        }

        while(!on_bridge_truck.isEmpty() || !waiting_truck.isEmpty()) {
            time++;
            if(!on_bridge_truck.isEmpty()) {
                if(time - on_bridge_truck.peek().enter_time >= bridge_length) {
                    total_weight -= on_bridge_truck.peek().weight;
                    on_bridge_truck.poll();
                }
            }

            if(!waiting_truck.isEmpty()) {
                if(total_weight + waiting_truck.peek().weight <= weight) {
                    total_weight += waiting_truck.peek().weight;
                    on_bridge_truck.offer(new Truck(time, waiting_truck.peek().weight));
                    waiting_truck.poll();
                }
            }
        }

        return time;
    }
}
