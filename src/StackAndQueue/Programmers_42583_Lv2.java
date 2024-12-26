package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_42583_Lv2 {
    static int[] inputTruckWeights;
    static int inputBridgeLength;
    static int inputWeight;
    static final String REGEX = "[\\[\\]\"\\s]";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                inputBridgeLength = stringToInt(br.readLine());
                inputWeight = stringToInt(br.readLine());
                inputTruckWeights = stringToIntArray(br.readLine());
                System.out.println(solution(inputBridgeLength, inputWeight, inputTruckWeights));
            } catch (IOException e) {
                break;
            }
        }
    }

    /**
     * 문자열을 숫자로 변환
     */
    public static int stringToInt(String string) {
        return Integer.parseInt(string);
    }

    /**
     * 문자열을 문자열 배열로 변환
     */
    public static String[] stringToArray(String string) {
        return string.replaceAll(REGEX, "").split(",");
    }

    /**
     * 문자열을 정수 배열로 변환
     */
    public static int[] stringToIntArray(String string) {
        String[] s = string.replaceAll(REGEX, "").split(",");
        int[] a = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        return a;
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> passQueue = new LinkedList<>();

        int truckIndex = 0;
        int time = 0;
        int weightOnBridge = 0;

        while (truckIndex < truck_weights.length || !passQueue.isEmpty()) {

            time++;

            if (!passQueue.isEmpty()){
                Truck truck = passQueue.peek();

                //트럭이 다리에 올라간 시점(1)과 현재 시점(5)의 차이를 구하여 다리의 길이(4)와 같으면 다 건넌 것이다.
                if (time - truck.time == bridge_length){
                    weightOnBridge -= truck.weight;
                    passQueue.remove();
//                    System.out.println(truck.weight + " 제거 " + time);
                }
            }

            if (truckIndex < truck_weights.length && weightOnBridge + truck_weights[truckIndex] <= weight && passQueue.size() < bridge_length) {
                passQueue.add(new Truck(truck_weights[truckIndex], time));
                weightOnBridge += truck_weights[truckIndex];
//                System.out.println(truck_weights[truckIndex] + " 삽입 " + time);
                truckIndex++;

            }
        }

        return time;
    }

    static class Truck {
        int weight;
        int time;

        Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}
