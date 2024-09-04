package InputOutput;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10950 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++)
        {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(a+b + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
