package dynamicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] tree = new int[N+1][N+1];
//        list.add(0); // index 1부터로 맞추려고
        //         1
        //       2  3
        //     4  5   6
        //   7   8   9   10
        // 11 12 13 14 15
        int[] arr = new int[N];
        for (int i = 1; i <= N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < temp.length; j++) {
                tree[i][j+1] = Integer.parseInt(temp[j]);
            }
        }
        int[][] dp = new int[N+1][N+1];
        dp[1][1] = tree[1][1];
        //dp[i][j] = list.index(현재값) + max(dp[i-1][j-1], dp[i-1][j])

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (j==1){
                    dp[i][j] = tree[i][j] + dp[i-1][j];
                    continue;
                }
                if (dp[i-1][j-1] < dp[i-1][j]){
                    dp[i][j] = tree[i][j] + dp[i-1][j];
                }else{
                    dp[i][j] = tree[i][j] + dp[i-1][j-1];
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int max = 0;
        for(int i=1;i<=N;i++){
            if(dp[N][i] > max){
                max = dp[N][i];
            }
        }
        stringBuilder.append(max);
//        for (int i = 2; i <= N; i++) {
//            for (int j = 1; j <= i; j++) {
//                stringBuilder.append(dp[i][j]).append(" ");
//            }
//            stringBuilder.append("\n");
//        }
        System.out.println(stringBuilder);
        br.close();
    }
}
