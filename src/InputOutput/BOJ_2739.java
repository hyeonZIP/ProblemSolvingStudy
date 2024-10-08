package InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=9; i++)
        {
            sb.append(num).append(" * ").append(i).append(" = ").append(i*num).append('\n');
        }
        System.out.print(sb);
    }
}
