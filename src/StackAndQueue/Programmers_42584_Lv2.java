package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Programmers_42584_Lv2 {
    static int[] inputPrices;
    static final String REGEX = "[\\[\\]\"\\s]";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                inputPrices = stringToIntArray(br.readLine());
                System.out.println(Arrays.toString(solution(inputPrices)));
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
    public static int[] solution(int[] prices) {

        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        deque.push(0);

        for (int i = 1; i < prices.length; i++) {
            while (!deque.isEmpty() && prices[i] < prices[deque.peek()]) {
                int index = deque.pop();
                answer[index] = i - index;
            }

            deque.push(i);
        }

        while (!deque.isEmpty()) {
            int index = deque.pop();
            answer[index] = prices.length - index - 1;
        }

        return answer;
    }
}
