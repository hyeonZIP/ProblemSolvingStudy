import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i=1; i<=N; i++)
        {
            for (int j=0; j<N-i; j++)
            {
                sb.append(' ');
            }
            for (int k=0; k<i*2-1; k++)
            {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
