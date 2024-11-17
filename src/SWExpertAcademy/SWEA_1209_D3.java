package SWExpertAcademy;

import java.util.*;

/**
 * SWEA_1209_D3 : [S/W 문제해결 기본] 2일차 - Sum [D3]
 * 단순 계산
 * 코드줄을 줄인다고 하면 2차원 배열을 입력 받음과 동시에 최대값을 저장하도록 수정
 */

public class SWEA_1209_D3 {

    static int[][] arr;
    static int rowMax;//가로
    static int colMax;//세로
    static int crossMax;//대각선

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T;
            T=sc.nextInt();
            arr = new int[101][101];
            rowMax = 0;
            colMax = 0;
            crossMax = 0;

            for (int i=1; i<=100; i++){
                int row = 0;
                for (int j=1; j<=100; j++){
                    arr[i][j] = sc.nextInt();
                    row += arr[i][j];
                }
                rowMax = Math.max(rowMax, row);
            }
            for (int i=1; i<=100; i++){
                int col = 0;
                for (int j=1; j<=100; j++){
                    col += arr[j][i];
                }
                colMax = Math.max(colMax, col);
            }
            int rowColMax = Math.max(rowMax, colMax);
            int rightDownCross = 0;
            for (int i=1; i<=100; i++){
                rightDownCross += arr[i][i];
            }
            int leftDownCross = 0;
            for (int i=1; i<=100; i++){
                leftDownCross += arr[i][101-i];
            }
            crossMax = Math.max(rightDownCross, leftDownCross);

            System.out.println("#" + T + " " + Math.max(crossMax,rowColMax));
        }
    }
}
