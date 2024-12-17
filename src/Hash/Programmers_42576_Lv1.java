package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Programmers_42576_Lv1 {
    static String[] inputParticipant;
    static String[] inputCompletion;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                inputParticipant = stringToArray(br.readLine());
                inputCompletion = stringToArray(br.readLine());
                System.out.println(solution(inputParticipant, inputCompletion));
            } catch (IOException e) {
                break;
            }
        }
    }

    /**
     * 문자열을 문자열 배열로 변환
     * [leo,kiki,eden] -> String[] inputParticipant = {leo,kiki,eden}
     */
    public static String[] stringToArray(String string) {
        return string.substring(1, string.length() - 1).split(",");
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        for (String s : map.keySet()) {
            if (map.get(s) != 0) {
                return s;
            }
        }
        return null;
    }
}
