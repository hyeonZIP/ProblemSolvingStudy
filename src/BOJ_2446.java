import java.io.*;

public class BOJ_2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String space = " ";
        String star = "*";

        for (int i=0; i<N; i++)
        {
            sb.append(space.repeat(i));
            sb.append(star.repeat(2*N-2*i-1)).append('\n');
        }
        for (int i=N-2; i>=0; i--)
        {
            sb.append(space.repeat(i));
            sb.append(star.repeat(2*N-2*i-1)).append('\n');
        }
        System.out.print(sb);
    }
}
