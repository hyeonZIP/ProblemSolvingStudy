package SWExpertAcademy;

/**
 * SWEA_1859 : 백만 장자 프로젝트 [D2]
 * 거꾸로 생각하기
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1859_D2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            //변수 선언
            long max = Long.MIN_VALUE;
            long earnMoney = 0L;
            List<Integer> arr = new ArrayList<>();

            //입력값 받기
            int N = sc.nextInt();
            for (int i = 0; i<N; i++){
                arr.add(sc.nextInt());
            }

            // 메인 로직
            // 1. 마지막 원소는 판매만 한다
            // 2. 해당 원소가 최대값일 경우 앞의 원소들은 전부 구매하면 된다
            // 3. 만약 마지막 원소보다 높은 값이 나올 경우 최대값을 갱신한다
            // 4. 2번부터 반복한다
            for (int i = arr.size()-1; i>=0; i--){
                if (arr.get(i)>max){
                    max = arr.get(i);
                }
                else{
                    earnMoney += max - arr.get(i);
                }
            }

            System.out.println("#" + test_case + " " + earnMoney);
        }
    }
}
