package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Programmers_42578_Lv2 {
    static String[][] inputClothes;
    static final String REGEX = "[\\[\\]\"\\s]";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                stringTo2DArray(br.readLine());
                System.out.println(solution(inputClothes));
            } catch (IOException e) {
                break;
            }
        }
    }

    /**
     * 문자열을 2차원 문자열 배열로 변환
     */
    public static void stringTo2DArray(String string) {
        String[] array = string.replaceAll(REGEX,"").split(",");
        inputClothes = new String[array.length/2][2];
        for (int i=0; i<array.length/2; i++) {
            System.arraycopy(array, (i * 2), inputClothes[i], 0, 2);
        }
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            int curNum = entry.getValue();
            sum += curNum*(sum+1);
        }

        return sum;
    }
}
