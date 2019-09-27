package com.example.algorithm.stackAndQueue;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class QueueExample {
    /**
     * * 스택 메서드
     *
     * boolean empty()  - true , false 로 비었는지 리턴함
     *
     * Object peek() - 스택의 최상위 (젤늦게 넣은) 객체를 반환 / Only 출력개념
     *
     * Object pop() - 스택의 최상위 객체를 꺼낸다 / 꺼내면 객체는 사라짐
     *
     * Object push(Object item) - 스택에 객체를 저장한다.
     *
     *
     *
     * * 큐 메서드
     *
     * Object element() - 저장된 요소를 불러옴
     *
     * boolean offer(Object o ) - Queue에 객체 저장 ( true : 성공, false : 실패 ) 반환
     *
     * Object peek() - 저장된 객체를 반환 / 없을경우 Null 을 반환
     *
     * Object poll() - 객체를 꺼내온다 / 꺼낸객체는 사라짐
     * **/
    /**
     * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
     * ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
     *
     * 예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
     *
     * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
     * 0	[]	[]	[7,4,5,6]
     * 1~2	[]	[7]	[4,5,6]
     * 3	[7]	[4]	[5,6]
     * 4	[7]	[4,5]	[6]
     * 5	[7,4]	[5]	[6]
     * 6~7	[7,4,5]	[6]	[]
     * 8	[7,4,5,6]	[]	[]
     * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
     *
     * solution 함수의 매개변수로 다리 길이 bridgelength, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truckweights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
     *
     * 제한 조건
     * bridge_length는 1 이상 10,000 이하입니다.
     * weight는 1 이상 10,000 이하입니다.
     * truck_weights의 길이는 1 이상 10,000 이하입니다.
     * 모든 트럭의 무게는 1 이상 weight 이하입니다.
     * 입출력 예
     * bridge_length	weight	truck_weights	return
     * 2	10	[7,4,5,6]	8
     * 100	100	[10]	101
     * 100	100	[10,10,10,10,10,10,10,10,10,10]	110
     * **/
    public int truck(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        //다리를 건너기 전에 대기 트럭 리스트
        Queue<Truck> q_wait = new LinkedList<>();

        //다리를 건너는 트럭 리스트
        Queue<Truck> q_onBridge = new LinkedList<>();

        int onBridgeWeight = 0;

        for (int w : truck_weights) {
            q_wait.add(new Truck(w, 0));
        }

        onBridgeWeight += q_wait.peek().weight;
        q_onBridge.add(q_wait.poll());

        int time = 0;

        while(!q_onBridge.isEmpty()) {
            time++;

            for (Truck t : q_onBridge) {
                //다리위 트럭들을 움직임
                t.index++;
            }

            //트럭이 다리 끝에 다다름
            if (q_onBridge.peek().index > bridge_length) {
                onBridgeWeight -= q_onBridge.poll().weight;
            }

            //대기 중 트럭을 다리에 올림 (무게 고려해야함 )
            if (!q_wait.isEmpty() && q_wait.peek().weight + onBridgeWeight <= weight ) {
                onBridgeWeight += q_wait.peek().weight;
                q_wait.peek().index++;
                q_onBridge.add(q_wait.poll());
            }
        } //while 끝

        answer = time;

        return answer;
    }
    static class Truck {
        int weight;
        int index;

        public Truck (int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }
}
