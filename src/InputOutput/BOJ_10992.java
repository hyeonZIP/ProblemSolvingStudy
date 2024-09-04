package InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i=1; i<N; i++)
        {
//            for (int j=0; j<N-i; j++)
//            {
//                sb.append(' ');
//            }
            sb.append(" ".repeat(N-i));
            sb.append('*');

//            for (int j=0; j<(i-1)*2-1; j++)
//            {
//                sb.append(' ');
//            }
            if (i>1)
            {
                sb.append(" ".repeat((i-1)*2-1));
                sb.append('*').append('\n');
            }
            else
            {
                sb.append('\n');
            }

        }

        for (int j=0; j<2*N-1; j++)
        {
            sb.append('*');
        }

        System.out.println(sb);
    }
}
