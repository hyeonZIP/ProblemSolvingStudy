package DynamicProgamming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {

    public static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        dp = new Integer[X+1];
        dp[0] = dp[1] = 0;

        System.out.println(calc(X));
    }

    public static int calc(int X)
    {
        if (X==1)
        {
            return 0;
        }

        if (dp[X] != null)
        {
            return dp[X];
        }

        //6의 배수처럼 2또는 3으로 둘다 나누어지는 경우
        //2와 3중 둘중 최소값을 할당 해주어야 한다
        if (X % 6 == 0)
        {
            dp[X] = Math.min(Math.min(calc(X/3), calc(X/2)),calc(X-1))+1;
        }
        else if (X % 3 == 0)
        {
            dp[X] = Math.min(calc(X/3),calc(X-1))+1;
        }
        else if (X % 2 == 0)
        {
            dp[X] = Math.min(calc(X/2),calc(X-1))+1;
        }
        //2또는 3으로 나눠지지 않는 수 일 경우 1을 빼준다
        else
        {
            dp[X] = calc(X-1) + 1;
        }

        return dp[X];
    }
}
