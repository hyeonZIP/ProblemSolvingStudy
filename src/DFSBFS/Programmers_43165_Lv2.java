package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmers_43165_Lv2 {
    static int[] inputNumbers;
    static int inputTarget;
    static final String REGEX = "[\\[\\]\"\\s]";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                inputNumbers = stringToIntArray(br.readLine());
                inputTarget = stringToInt(br.readLine());
                System.out.println(solution(inputNumbers, inputTarget));
                answer = 0;
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

    static int[] arr;
    static int targetNum = 0;
    static int answer = 0;

    public static int solution(int[] numbers, int target) {

        arr = new int[numbers.length];
        targetNum = target;

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = numbers[i];
        }

        dfs(arr[0], 1);
        dfs(-1 * arr[0], 1);

        return answer;
    }

    public static void dfs(int number, int index) {
        if (number == targetNum && index == arr.length) {
            answer++;
            return;
        }

        if (index >= arr.length) {
            return;
        }
        dfs(number - arr[index], index + 1);
        dfs(number + arr[index], index + 1);
    }
}
