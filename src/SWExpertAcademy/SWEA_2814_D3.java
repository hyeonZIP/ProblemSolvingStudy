package SWExpertAcademy;

import java.util.*;

/**
 * SWEA_2814_D3 : 최장 경로 [D3]
 * 2차원 배열을 이용하여 입력값 저장
 * visit 배열을 이용하여 방문 여부 저장
 * 백트래킹으로 이전 방문 여부 취소
 */

public class SWEA_2814_D3 {
    static int N,M,result,resultCount;
    static int[][] arr;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[N+1][N+1];

            result = 1;
            resultCount = 1;
            for (int i = 0; i<M; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = arr[y][x] = 1;
            }
            for (int i= 1; i<=N; i++){
                visit = new boolean[N+1];
                dfs(1, i);
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

    static void dfs(int count, int node){
        visit[node] = true;

        for (int i = 1; i<N+1; i++){
            if (arr[node][i] == 1 && visit[i] == false){
                dfs(count+1,i);
                visit[i] = false;
            }
        }
        result = Math.max(result, count);
    }
}
