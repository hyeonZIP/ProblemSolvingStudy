import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String space = " ";
        String space_star = " *";

        for (int i=N-1; i>=0; i--)
        {
            sb.append(space.repeat(i));
            sb.append('*');
            sb.append(space_star.repeat(N-i-1)).append('\n');
        }
        System.out.print(sb);
    }
}
