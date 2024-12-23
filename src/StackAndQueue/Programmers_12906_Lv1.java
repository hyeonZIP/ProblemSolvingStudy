package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Programmers_12906_Lv1 {
    static int[] inputArr;
    static final String REGEX = "[\\[\\]\"\\s]";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                inputArr = stringToIntArray(br.readLine());
                System.out.println(solution(inputArr));
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

    public static Stack<Integer> solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for (int i=1; i<arr.length; i++){
            if (stack.peek() != arr[i]){
                stack.push(arr[i]);
            }
        }
        return stack;
    }
}
