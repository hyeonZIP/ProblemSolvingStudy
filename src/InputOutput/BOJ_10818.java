package InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.parseInt(st.nextToken());
        int min = max;

        for (int i=0; i<N-1; i++)
        {
            int curnum = Integer.parseInt(st.nextToken());

            max = Math.max(max, curnum);
            min = Math.min(min, curnum);
        }
        System.out.println(sb.append(min).append(' ').append(max));
    }
}
