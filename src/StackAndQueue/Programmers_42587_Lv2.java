package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers_42587_Lv2 {
    static int[] inputPriorities;
    static int inputLocation;
    static final String REGEX = "[\\[\\]\"\\s]";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                inputPriorities = stringToIntArray(br.readLine());
                inputLocation = stringToInt(br.readLine());
                System.out.println(solution(inputPriorities, inputLocation));
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

    public static int solution(int[] priorities, int location) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int p : priorities) {
            pq.offer(p);
        }

        int index = 0;
        int targetIndex = 0;
        while (!pq.isEmpty()) {
            int head = pq.poll();

            if (head != priorities[index]) {
                pq.offer(head);
            }
            else {
                targetIndex++;
                if (index == location){
                    return targetIndex;
                }
            }
            index++;
            if (index == priorities.length) {
                index = 0;
            }
        }
        return -1;
    }
}
