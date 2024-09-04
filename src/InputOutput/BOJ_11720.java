package InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s;
        int sum = 0;
        if (N > 0)
        {
            s = br.readLine();

            for (int i=0; i<N; i++)
            {
                sum += (int) s.charAt(i)-'0';
            }
        }
        System.out.println(sum);

        br.close();
    }
}
