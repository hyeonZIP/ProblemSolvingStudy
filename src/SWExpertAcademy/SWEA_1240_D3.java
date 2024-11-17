package SWExpertAcademy;

import java.util.*;

/**
 * SWEA_1240_D3 : [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드 [D3]
 * 단순 문자열 분리 작업
 * 코드줄을 줄이기 위해서 0110001 을 5로 변환하는 과정을 생략하는 것
 */

public class SWEA_1240_D3 {
    static int N,M;
    static Map<String,Integer> map = new HashMap<>();
    static{
        map.put("3211",0);
        map.put("1231",5);
        map.put("2221",1);
        map.put("1114",6);
        map.put("2122",2);
        map.put("1312",7);
        map.put("1411",3);
        map.put("1213",8);
        map.put("1132",4);
        map.put("3112",9);
    }
    static boolean flag = false;
    static boolean flag2 = true;
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            M = sc.nextInt();

            int codeFin = 0;
            int codeStart = 0;
            String decode = "";

            for (int i=0; i<N; i++){
                String code = sc.next();
                if (code.contains("1") && flag2){
                    codeFin = code.lastIndexOf("1");
                    codeStart = codeFin-56+1;
                    flag = true;
                }
                int oneCount = 0;
                int zeroCount = 0;
                if (flag){
                    for (int j=codeStart; j<=codeFin; j++){
                        if (code.charAt(j)=='1'){
                            oneCount++;
                            if (zeroCount !=0){
                                decode += zeroCount;
                                zeroCount=0;
                            }
                            if (j==codeFin){
                                decode += oneCount;
                            }
                        }
                        else{
                            zeroCount++;
                            if (oneCount !=0){
                                decode += oneCount;
                                oneCount=0;
                            }
                        }
                    }
                    flag = false;
                    flag2 = false;
                }
            }
            int[] decodeNumber = new int[8];
//            System.out.println(decode);

            List<String> decodeString = new ArrayList<>();
            for (int i=0; i<=28; i=i+4){
                decodeString.add(decode.substring(i,i+4));
            }
            int j = 0;
            for (String s : decodeString){
                for (String m : map.keySet()){
                    if (s.equals(m)){
                        decodeNumber[j] = map.get(m);
                        j++;
                    }
                }
            }

//            System.out.println(Arrays.toString(decodeNumber));
            int wkrtn = 0;
            int ghftn = 0;
            int sum;
            for (int i = 0; i<8; i++){
                if (i % 2 == 0){
                    ghftn += decodeNumber[i];
                }
                else {
                    wkrtn += decodeNumber[i];
                }
            }
//            System.out.println("짝수 : " + wkrtn);
//            System.out.println("홀수 : " + ghftn);

            if ((ghftn*3 + wkrtn) % 10 !=0){
                System.out.println("#" + test_case + " 0");
            }
            else{
                sum = wkrtn+ghftn;
                System.out.println("#" + test_case + " " + sum);
            }
            flag = false;
            flag2 = true;
        }
    }
}
