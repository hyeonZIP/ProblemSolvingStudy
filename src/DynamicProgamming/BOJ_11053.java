package DynamicProgamming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * dp배열에는 항상 N자리 수 일때의 경우의 수를 할당한다.
         */

        for (int i=0; i<N; i++)
        {
            dp[i] = 1;

            for (int j=0; j<i; j++)
            {
                if (arr[i]>arr[j] && dp[i]<dp[j]+1)
                {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = -1;

        for (int i=0; i<N; i++)
        {
            if (dp[i]>max)
            {
                max = dp[i];
            }
        }

        System.out.println(max);


    }
}
