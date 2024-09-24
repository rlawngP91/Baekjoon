package dynamicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjon2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1~300

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        // int[N][0] : 선택하지 않았을때, int[N][1] : N을 선택했을때

        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[2];

        // dp[i] = arr[i] + max(dp[i-2], dp[i-3] + arr[i-1])
        // 뒤에서부터 탐색해서 내려오기
        int flag = 0; // 두개 연속으로 선택하지 않기 위한 flag
        for (int i = 3; i <= N; i++) {
            if (dp[i-2] < (dp[i-3] + arr[i-1])){
                dp[i] = arr[i] + dp[i-3] + arr[i-1];
            }else{
                dp[i] = arr[i] + dp[i-2];
            }
        }
        System.out.println(dp[N]);
        br.close();
    }
}
//        6

//        10
//        20
//        15
//        25
//        10
//        20
//
// 75

// 20 20
// 20 30 flag = 1
// 45 55 flag = 2
// 45 55 60
// 55 75
//