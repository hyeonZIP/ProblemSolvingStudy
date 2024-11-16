package SWExpertAcademy;

import java.util.Scanner;

/**
 * SWEA_1244 : [S/W 문제해결 응용] 2일차 - 최대 상금 [D3]
 * DFS 와 BackTracking(원상복구) 활용
 */

public class SWEA_1244_D3 {
    static int arr[];
    static int N;
    static int max;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String s = sc.next();
            arr = new int[s.length()];

            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i) - '0';
            }

            N = sc.nextInt();

            max = 0;

            dfs(0,0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    static void dfs(int start, int count){
        if (count==N){
            int result = 0;
            for (int a : arr){
                result = result*10 + a;
            }
            max = Math.max(max,result);
            return;
        }
        for (int i = start; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                dfs(i, count+1);

                //백트래킹(원상 복구)
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
