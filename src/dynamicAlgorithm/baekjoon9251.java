package dynamicAlgorithm;

import java.io.IOException;
import java.util.Scanner;

public class baekjoon9251 {

//            ABCABCDEA
//            ADCAB
//            4 (ACAB)
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        // toCharArray() 는 문자열을 char[] 배열로 반환해주는 메소드다.
        char[] c1 = in.nextLine().toCharArray();
        char[] c2 = in.nextLine().toCharArray();
//        String s1 = br.readLine();
//        String s2 = br.readLine();
//        if(s1 == null || s2 == null){
//            System.out.println(0);
//            return;
//        }
//        char[] c1 = s1.toCharArray();
//        char[] c2 = s2.toCharArray();

        if(c1.length== 0 || c2.length == 0){
            System.out.println(0);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        // 초기값 설정
        int[][] dp = new int[c1.length+1][c2.length+1];
        for (int i = 0; i <= c1.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= c2.length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    for (int k = (j); k <= c2.length; k++) {
                        dp[i][k] = dp[i-1][j-1] + 1;
                    }
                }else{
                    if(dp[i-1][j] < dp[i][j-1]){
                        dp[i][j] = dp[i][j-1];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
//        for (int i = 0; i <= c1.length; i++) {
//            for (int j = 0; j <= c2.length; j++) {
//                stringBuilder.append(dp[i][j]).append(" ");
//            }
//            stringBuilder.append("\n");
//        }

//        int[] dp = new int[c1.length];
//        int flag = 0;


//        for(int k=0 ; k < c1.length; k++){
//            flag = 0;
//            for (int i = k; i < c1.length; i++) {
//                for (int j = (flag); j < c2.length; j++) {
//                    if (c1[i] == c2[j]) {
//                        dp[k] ++;
////                        sum ++;
//                        flag = j;
//                        break;
//                    }
//                }
//            }
//        }

//        for (int i = 0; i < dp.length; i++) {
//            stringBuilder.append(dp[i]).append(" ");
//        }
        int max = 0;
        for(int i = 1 ; i <= c2.length ; i++){
            if(dp[c2.length][i] > max){
                max = dp[c2.length][i];
            }
        }
        System.out.println(max);
    }
}
//     C A P C A K
//   0 0 0 0 0 0 0
// A 0 0 1 1 1 1 1
// C 0 1 1 1 1 1 1
// A 0 1 2 2 2 2 2
// Y 0 1 2 2 2 2 2
// K 0 1 2 2 2 2 3
// P 0 1 2 3 3 3 3

//     C A P C A K
//   0 0 0 0 0 0 0
// A 0 0 1 1 1 1 1
// C 0 1 1 1 2 2 2
// A 0 1 2 2 2 3 3
// Y 0 1 2 2 2 3 3
// K 0 1 2 2 2 3 4
// P 0 1 2 3 3 3 4

//     C A P C A K
//   0 0 0 0 0 0 0
// C 0 1 1 1 1 1 1
// C 0 1 1 1 2 2 2
// A 0 1 2 2 2 3 3
// Y 0 1 2 2 2 3 3
// K 0 1 2 2 2 3 4
// P 0 1 2 3 3 3 4


