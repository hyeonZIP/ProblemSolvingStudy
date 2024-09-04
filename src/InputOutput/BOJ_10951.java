package InputOutput;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10951 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true)
        {
            String s = br.readLine();

            if(s == null || s.isEmpty())
            {
                break;
            }

            StringTokenizer st = new StringTokenizer(s);

            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}