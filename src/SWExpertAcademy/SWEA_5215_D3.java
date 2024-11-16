package SWExpertAcademy;

import java.util.Scanner;

/**
 * SWEA_5215_D3 : 햄버거 다이어트
 * 조합 문제
 * 해당 재료를 선택한 경우, 선택 안한 경우를 생각하여 함수를 호출한다
 */

public class SWEA_5215_D3 {
    static int[][] arr;
    static int maxCalorie, foodCount, maxScore;
    final static int CALORIE = 1;
    final static int SCORE = 0;
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            foodCount = sc.nextInt();
            maxCalorie = sc.nextInt();
            arr = new int[foodCount][2];
            maxScore = 0;

            for (int i = 0; i < foodCount; i++){
                arr[i][SCORE] = sc.nextInt();
                arr[i][CALORIE] = sc.nextInt();
            }

            dfs(0,0,0);

            System.out.println("#" + test_case +" " + maxScore);
        }
    }

    static void dfs(int start, int calorie, int score){
        if (calorie > maxCalorie){
            return;
        }
        if (start == foodCount){
            maxScore = Math.max(score, maxScore);
            return;
        }
        dfs(start+1,calorie+arr[start][CALORIE],score+arr[start][SCORE]);

        dfs(start+1,calorie,score);
    }
}
