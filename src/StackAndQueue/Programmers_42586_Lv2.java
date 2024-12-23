package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_42586_Lv2 {
    static int[] inputProgresses;
    static int[] inputSpeeds;
    static final String REGEX = "[\\[\\]\"\\s]";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                inputProgresses = stringToIntArray(br.readLine());
                inputSpeeds = stringToIntArray(br.readLine());
                System.out.println(solution(inputProgresses, inputSpeeds));
            } catch (IOException e) {
                break;
            }
        }
    }

    /**
     * 문자열을 문자열 배열로 변환
     */
    public static String[] stringToArray(String string) {
        return string.replaceAll(REGEX,"").split(",");
    }
    /**
     * 문자열을 정수 배열로 변환
     */
    public static int[] stringToIntArray(String string) {
        String[] s = string.replaceAll(REGEX,"").split(",");
        int[] a = new int[s.length];
        for (int i=0; i<s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        return a;
    }

    public static List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<progresses.length; i++){
            int count = 0;
            while(progresses[i] < 100){
                progresses[i] += speeds[i];
                count++;
            }
            queue.add(count);
        }

        List<Integer> answer = new ArrayList<>();
//        System.out.println(queue);
        int num = queue.remove();
        int count = 1;
        while(!queue.isEmpty()){
            int nextNum = queue.remove();
            if (num >= nextNum){
                count++;
            }
            else{
                answer.add(count);
                num = nextNum;
                count = 1;
            }
        }
        answer.add(count);

        return answer;
    }
}
