package SWExpertAcademy;

import java.util.*;

/**
 * SWEA_1204 : [S/W 문제해결 기본] 1일차 - 최빈수 구하기 [D2]
 * Map을 이용하면 편리하게 구현할 수 있다
 */

public class SWEA_1204_D2 {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int frequency = 0;
            int max = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j<1000; j++){
                map.merge(sc.nextInt(), 1, Integer::sum);
            }

            for (int i : map.keySet()){
                int count = map.get(i);
                if (count > frequency || (count == frequency && max < i)){
                    frequency = count;
                    max = i;
                }
            }

            System.out.printf("#%d %d%n", N, max);
        }
    }
}
