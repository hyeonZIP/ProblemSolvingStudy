package InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String space = " ";
        String star = "*";

        for (int i=0; i<N; i++)
        {
            sb.append(space.repeat(N-i-1));
            sb.append(star.repeat(i+1)).append('\n');
        }
        for (int i=0; i<N-1; i++)
        {
            sb.append(space.repeat(i+1));
            sb.append(star.repeat(N-1-i)).append('\n');
        }
        System.out.print(sb);
    }
}