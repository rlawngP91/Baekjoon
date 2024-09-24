package dynamicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjon11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1~1,000

//        int end = 1;
//        for (int i = 0; i < N; i++) {
//            end *= 10;
//        }
//        int start = end/10;
//        System.out.println(start);
//        System.out.println(end);
        StringBuilder st = new StringBuilder();
        int[][] dp = new int[N+1][10];
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[1][1] = 9;
        if (N == 1) {
            System.out.println(10);
            return;
        }
        for (int i = 0; i < 10; i++) {
            dp[2][i] = 10-i;
        }
        for (int i = 3; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = 0;
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] %= 10007;
            }
        }
        //1 -10
        //2 - 55
        //3 - 220

        // 2차원 배열
        // dp[][]
        // dp[1] : 0 9
        // dp[2] : 10 9 8 7 6 5 4 3 2 1
        // dp[3] : dp[2][1]~dp[2][10] dp[2][2]~dp[2][10] dp[2][3]~dp[2][10] ...
        // dp[4] : dp[3][1]~dp[3][10] dp[3][2]~dp[3][10] ...
        // dp[5] :  dp[4][1] ~

            // 01, 02, 03, ... - 10
            // 11, 12, 13, 14, ..., 19 - 9
            // 22, 23, ..., 29 - 8
            // 33, 34, ..., 39

            // ex) 100~999 까지 오름차수 구하기
            // 111, 112, 113, ..., 119 : 9
            // 122, 123, 124, ..., 129 : 8
            // 133, 134, 135, ..., 139 : 7 -> 9+8+7+6+...+1
            // ...
            // 222, 223, 224, ..., 229 : 8
            // 233, 234, 235, ..., 239 : 7
            // 244, 245, 246, ..., 249 : 6 -> 8+7+6+...+1
            // ...
            // 333, 334, 335, .., 339 : 7 -> 7+6+...+1
            // ...
            // 444, 445, 446, ..., 449 : 6
            // ...

            // ex) 1000~9999
            // 1111, 1112, 1113, ..., 11119: 9
            // ...dp[3]

            // 2222, 2223, 2224, ..., 2229 : 8
            // 222

            // 10000
            //
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i).append(" : ");
            for (int j = 0; j < 10; j++) {
                sb.append(dp[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

        int result = 0;
        for(int i = 0; i < 10 ; i++){
            result += dp[N][i];
        }
        result %= 10007;
        st.append(result).append("\n");
        System.out.println(st);
        br.close();
    }
}
//        1
//        10
//
//        2
//        55
//
//        3
//        220
//
//        4
//        715
//
//        5
//        2002
//
//        6
//        5005
//
//        7
//        1433
//
//        8
//        4296
//
//        9
//        8592
//
//        10
//        2315
//
//        11
//        7848
//
//        12
//        3727
//
//        13
//        7077
//
//        18
//        3549
//
//        100
//        3831
//
//        1000
//        1464
//
//        500
//        8045
//
//        499
//        6153