package SWExpertAcademy;

import java.util.Scanner;

/**
 * SWEA_1206 : [S/W 문제해결 기본] 1일차 - View [D3]
 * 2차원 배열에 건물 정보를 넣고 좌우 2칸을 확인한다
 * 탐색 시간을 단축시키려면 다음 층이 존재하지 않을 경우 다음 건물로 넘어가게 한다
 */

public class SWEA_1206 {
    final static int MAX = 255;
    final static int TEST_CASE = 10;
    static int result = 0;
    static int buildingCount = 0;
    static int[][] arr;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        for (int i=0; i<TEST_CASE; i++){
            setFunc();
            calcFunc();
            testFunc(i);
        }
        System.out.println(sb);
    }

    private static void setFunc(){
        buildingCount = sc.nextInt();
        arr = new int[MAX][buildingCount];
        for (int i=0; i<buildingCount; i++){
            int height = sc.nextInt();
            for (int j = 0; j < height; j++){
                arr[j][i] = 1;
            }
        }
    }

    private static void calcFunc(){
        for (int i = 0; i<MAX; i++){
            for (int j = 2; j<buildingCount-2; j++){
                if (arr[i][j] == 1 && arr[i][j-1] == 0 && arr[i][j-2] == 0 &&arr[i][j+1] == 0 &&arr[i][j+2] == 0){
                    result++;
                }
            }
        }
    }

    private static void testFunc(int i){
        sb.append("#").append(i+1).append(" ").append(result).append("\n");
        result = 0;
    }
}


