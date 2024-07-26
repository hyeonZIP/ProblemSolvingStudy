import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i =0; i<N; i++)
        {
            for (int j=0; j<N-1-i; j++)
            {
                sb.append(' ');
            }
            for (int k=0; k<i+1; k++)
            {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
