package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_12909_Lv2 {
    static String inputString;
    static final String REGEX = "[\\[\\]\"\\s]";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                inputString = stringFormat(br.readLine());
                System.out.println(solution(inputString));
            } catch (IOException e) {
                break;
            }
        }
    }
    /**
     * 기호 제거한 문자열 반환
     */
    public static String stringFormat(String string){
        return string.replaceAll(REGEX,"");
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

    public static boolean solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        boolean answer = false;
        for(int i=0; i<s.length(); i++){
            queue.offer(s.charAt(i));
        }

        int left = 0;
        while(!queue.isEmpty()){
            char current = queue.remove();
            if (current == '('){
                left++;
                continue;
            }
            left--;
            if (left < 0){
                break;
            }
        }

        if (left ==0){
            answer = true;
        }

        return answer;
    }
}
