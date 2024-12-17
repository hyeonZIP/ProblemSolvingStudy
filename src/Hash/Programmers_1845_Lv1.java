package Hash;

import java.io.*;
import java.util.HashMap;

public class Programmers_1845_Lv1 {

    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                stringToArray(br.readLine());
                System.out.println(solution(input));
            } catch (IOException e) {
                break;
            }
        }
    }

    /**
     * 문자열을 정수형 배열로 변환
     * [3,1,2,3] -> int[] nums = {3,1,2,3}
     */
    public static void stringToArray(String string) {
        String[] stringArray = string.substring(1, string.length() - 1).split(",");
        input = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            input[i] = Integer.parseInt(stringArray[i]);
        }
    }

    public static int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int ponketmonType = map.keySet().size();
        int takableNumber = nums.length / 2;

        return Math.min(ponketmonType, takableNumber);
    }
}
