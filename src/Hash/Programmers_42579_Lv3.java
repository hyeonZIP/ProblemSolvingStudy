package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Programmers_42579_Lv3 {
    static String[] inputGenres;
    static int[] inputPlays;
    static final String REGEX = "[\\[\\]\"\\s]";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                inputGenres = stringToArray(br.readLine());
                inputPlays = stringToIntArray(br.readLine());
                System.out.println(solution(inputGenres,inputPlays));
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

    public static List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> playsCount = new HashMap<>();//장르별 재생횟수 저장

        for (int i=0; i<genres.length; i++) {
            playsCount.put(genres[i],playsCount.getOrDefault(genres[i],0) + plays[i]);
        }

        List<Map.Entry<String,Integer>> playsList = new ArrayList<>(playsCount.entrySet());//해시맵 리스트로 변환
        playsList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));//내림차순 정렬

        HashMap<String, HashMap<Integer,Integer>> album = new HashMap<>();//장르별로 고유번호별 재생횟수 저장

        for (String genre : playsCount.keySet()){
            HashMap<Integer,Integer> innerMap = new HashMap<>();
            for (int i=0; i<genres.length; i++){
                if (genres[i].equals(genre)){
                    innerMap.put(i,plays[i]);
                }
            }

            album.put(genre,innerMap);
        }

        for(Map.Entry<String, Integer> entry : playsList){
            String genre = entry.getKey();//재생 수가 많은 장르 부터 뽑음

            HashMap<Integer,Integer> idxPlays = album.get(genre);

            List<Map.Entry<Integer,Integer>> idxPlaysList = new ArrayList<>(idxPlays.entrySet());
            idxPlaysList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            for (int i=0; i<idxPlaysList.size() && i!=2; i++){
                answer.add(idxPlaysList.get(i).getKey());
            }
        }

        return answer;
    }
}
