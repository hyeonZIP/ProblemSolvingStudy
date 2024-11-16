package SWExpertAcademy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * SWEA_1208_D3 : [S/W 문제해결 기본] 1일차 - Flatten [D3]
 * 단순 정렬
 */

public class SWEA_1208_D3 {
    static int[] arr;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int dump = sc.nextInt();
            arr = new int[100];
            for (int i = 0; i < 100; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            for (int i = 0; i < dump; i++){
                if (Math.abs(arr[0] - arr[99]) != 1){
                    flatten();
                }
            }
            System.out.println("#" + test_case + " " + Math.abs(arr[0] - arr[99]));
        }
    }

    static void flatten(){
        arr[0]++;
        arr[99]--;
        Arrays.sort(arr);
    }
}
