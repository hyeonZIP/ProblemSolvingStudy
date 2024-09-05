package DynamicProgamming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];
        long result = 0;
        for (int i=1; i<=9; i++)
        {
            dp[1][i] = 1;//한 자리수 일 때 끝에 오는 수가 i인 계단 수는 1개
        }

        for (int i=2; i<=N; i++)
        {

            dp[i][0] = dp[i-1][1] % 1000000000; //0으로 끝나는 경우의 수 = 1로 끝나는 경우의 수
            dp[i][9] = dp[i-1][8] % 1000000000; //9로 끝나는 경우의 수 = 8로 끝나는 경우의 수
            for (int j=1; j<=8; j++)
            {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;// ex) 5로 끝나는 경우의 수 = 4로 끝나는 경우의 수 + 6으로 끝나는 경우의 수
            }
        }

        for (int i=0; i<=9; i++)
        {
            result += dp[N][i];
        }
        result %= 1000000000;

        System.out.println(result);
    }
}
