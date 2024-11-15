package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_21425 {
    public static void main(String[] args) throws IOException {
        /**
         * SWEA_21425 : += [D2]
         * 항상 작은 값에 더해주기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int count = 0;
            while(A<=N && B<=N){
                if (A>=B){
                    B+=A;
                    count++;
                }
                else {
                    A+=B;
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }


}
