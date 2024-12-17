package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Programmers_42577_Lv2 {
    static String[] inputPhoneBook;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                inputPhoneBook = stringToArray(br.readLine());
                System.out.println(solution(inputPhoneBook));
            } catch (IOException e) {
                break;
            }
        }
    }

    /**
     * 문자열을 문자열 배열로 변환
     * [119,97674223,1195524421] -> String[] inputParticipant = {leo,kiki,eden}
     */
    public static String[] stringToArray(String string) {
        return string.substring(1, string.length() - 1).split(",");
    }

    public static boolean solution(String[] phoneBook) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : phoneBook) {
            map.put(s, 0);
        }

        for (String i : map.keySet()) {
            for (int j = 0; j<i.length(); j++){
                System.out.println(i.substring(0,j));
                if (map.containsKey(i.substring(0,j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
