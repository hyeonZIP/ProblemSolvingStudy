package DynamicProgamming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11057 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

        for (int i=0; i<10; i++)
        {
            dp[1][i] = 1;//한자리수 오르막 수는 각각 한개 뿐
        }

        // DP 배열 채우기
        for (int i = 2; i <= N; i++) { // 자리수
            for (int j = 0; j < 10; j++) { // 끝나는 숫자
                for (int k = 0; k <= j; k++) { // j보다 작거나 같은 숫자를 더함
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
                }
            }
        }

        int result = 0;

        for (int i=0; i<10; i++)
        {
            result = (result + dp[N][i])%10007;
        }
        System.out.println(result);


    }
}
