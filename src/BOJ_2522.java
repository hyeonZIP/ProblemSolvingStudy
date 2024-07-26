//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class BOJ_2522 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(br.readLine());
//
//        for (int i=0; i<N; i++)
//        {
//            for (int j=0; j<N-i-1; j++)
//            {
//                sb.append(' ');
//            }
//            for (int k=0; k<i+1; k++)
//            {
//                sb.append('*');
//            }
//            sb.append('\n');
//        }
//        for (int i=0; i<N-1; i++)
//        {
//            for (int j=0; j<i+1; j++)
//            {
//                sb.append(' ');
//            }
//            for (int k=0; k<N-1-i; k++)
//            {
//                sb.append('*');
//            }
//            sb.append('\n');
//        }
//        System.out.println(sb);
//    }
//}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class BOJ_2522 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int count = Integer.parseInt(br.readLine());
//        String space = " ";
//        String star = "*";
//        for (int i=1; i <= count ; i++) {
//            sb.append(space.repeat(count-i));
//            sb.append(star.repeat(i)).append("\n");
//        }
//        for (int i=count-1; i >=1 ; i--) {
//            sb.append(space.repeat(count-i));
//            sb.append(star.repeat(i)).append("\n");
//        }
//        System.out.println(sb);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String space = " ";
        String star = "*";

        for (int i=0; i<N; i++)
        {
            sb.append(space.repeat(N-i-1));
            sb.append(star.repeat(i+1)).append('\n');
        }
        for (int i=0; i<N-1; i++)
        {
            sb.append(space.repeat(i+1));
            sb.append(star.repeat(N-1-i)).append('\n');
        }
        System.out.print(sb);
    }
}