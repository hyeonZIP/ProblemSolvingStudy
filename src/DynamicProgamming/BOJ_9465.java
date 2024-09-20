package DynamicProgamming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {

    static int[][] sticar;
    static int[][] dp;
    static int n;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++)
        {
            n = Integer.parseInt(br.readLine());

            sticar = new int[2][n]; //스티커 점수
            dp = new int[2][n];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int k=0; k<n; k++)
            {
                sticar[0][k] = Integer.parseInt(st1.nextToken());
                sticar[1][k] = Integer.parseInt(st2.nextToken());
            }

            dp[0][0] = sticar[0][0];
            dp[1][0] = sticar[1][0];

            int max = Math.max(dp[0][0], dp[1][0]);

            for (int j=1; j<n; j++)
            {
                if (j==1)
                {
                    dp[0][1] = dp[1][0] + sticar[0][1];
                    dp[1][1] = dp[0][0] + sticar[1][1];
                    max = Math.max(dp[0][1], dp[1][1]);
                    continue;
                }

                dp[0][j] = Math.max(dp[1][j-2], dp[1][j-1]) + sticar[0][j];
                dp[1][j] = Math.max(dp[0][j-2], dp[0][j-1]) + sticar[1][j];
                max = Math.max(dp[0][j], dp[1][j]);
            }

            sb.append(max + "\n");
        }

        System.out.println(sb);
    }
}
