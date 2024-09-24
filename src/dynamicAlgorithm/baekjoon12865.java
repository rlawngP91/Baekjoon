package dynamicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon12865 {

    // 몰라서 답지 확인..ㅜ
    // 행 : 담을 수 있는 최대 무게 (i kg까지 담을 수 있음)
    // 열 : 한도 무게가 i kg일때 담을 수 있는 아이템

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        int[] weight = new int[N+1];
        int[] value = new int[N+1];
        weight[0] = 0;
        value[0] = 0;
        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            weight[i] = Integer.parseInt(s[0]);
            value[i] = Integer.parseInt(s[1]);
        }

        int[][] dp = new int[K+1][N+1];
        // 최대 한도 무게가 0kg이라면 담을 수 있는 item이 없으므로 가치도 0
        for (int i = 0; i < N; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < K; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= K; i++) {
            int curWeight = i;
            for (int j = 0; j <= N; j++) {
                // 애초에 아이템의 무게가 최대한도무게(K)보다 큰 경우 -> 따져볼필요가 없음
                if (weight[j] > i)
                    continue;
                if (curWeight >= weight[j]) {
                    dp[i][j] = dp[i][j-1] + value[j];
                    curWeight -= weight[j];
                    continue;
                }
                if ((dp[(i-weight[j])][j-1] + value[j]) < dp[i][j-1]){
                    dp[i][j] = dp[i][j-1];
                }else{
                    dp[i][j] = dp[i-weight[j]][j-1] + value[j];
                    curWeight = i - weight[j];
                }
            }
        }



        br.close();
    }
}
//     x   6   4   3   5
// 0   0   0   0   0   0
// 1   0   0   0   0   0
// 2   0   0   0   0   0
// 3   0   0   0   6   6
// 4   0   0   8   8   8
// 5   0   0   8   8
// 6
// 7

