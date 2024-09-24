package dynamicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjon9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];
            for (int i = 0; i < 2; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(temp[j]);
                }
            }
            // dp[i-2][0]을 선택했을때 dp[i-2][0] + max(dp[i-1][1] + dp[i][0], dp[i][1])확인
            // dp[i-2][1]을 선택했을때 dp[i-2][1] + max(dp[i-1][0] + dp[i][1], dp[i][0])확인
            if(N < 3){  // 예외처리
                if(N==0){
                    sb.append(0);
                }
                if(N==1){
                    if(arr[0][0]<arr[1][0]){
                        sb.append(arr[1][0]);
                    }else{
                        sb.append(arr[0][0]);
                    }
                }
                if(N==2){
                    if((arr[0][0]+arr[1][1])<(arr[1][0]+arr[0][1])){
                        sb.append(arr[1][0]+arr[0][1]);
                    }else{
                        sb.append(arr[0][0]+arr[1][1]);
                    }
                }
                sb.append("\n");
                continue;
            }
            int[][] dp = new int[2][N];
            // N==홀수
            if(N%2==1){
                dp[0][0] = arr[0][0];
                dp[0][1] = arr[0][1];
                dp[1][0] = arr[1][0];
                dp[1][1] = arr[1][1];
                for (int i = 2; i < N; i++) { // 열
                    for (int j = 0; j < 2; j++) {   // 행
                        if(i%2==0){
                            if (j==0){
                                if ((dp[1][i-1] + dp[0][i-2]) < dp[1][i-2]){
                                    dp[j][i] = arr[j][i] + dp[1][i-2];
                                }else{
                                    dp[j][i] = arr[j][i] + dp[1][i-1] + dp[0][i-2];
                                }
                            }else{  // j == 1
                                if ((dp[0][i-1] + dp[1][i-2]) < dp[0][i-2]){
                                    dp[j][i] = arr[j][i] + dp[0][i-2];
                                }else{
                                    dp[j][i] = arr[j][i] + dp[0][i-1] + dp[1][i-2];
                                }
                            }
                        } else{
                            dp[j][i] = arr[j][i];
                        }
                    }
                }
            }
            if(N%2==0){
                // N==찍수
                dp[0][0] = arr[0][0];
                dp[0][1] = arr[0][1] + arr[1][0];
                dp[1][0] = arr[1][0];
                dp[1][1] = arr[1][1] + arr[0][0];
                for (int i = 3; i < N; i++) { // 열
                    for (int j = 0; j < 2; j++) {   // 행
                        if(i%2==1){
                            if (j==0){
                                if ((dp[1][i-1] + dp[0][i-2]) < dp[1][i-2]){
                                    dp[j][i] = arr[j][i] + dp[1][i-2];
                                }else{
                                    dp[j][i] = arr[j][i] + dp[1][i-1] + dp[0][i-2];
                                }
                            }else{  // j == 1
                                if ((dp[0][i-1] + dp[1][i-2]) < dp[0][i-2]){
                                    dp[j][i] = arr[j][i] + dp[0][i-2];
                                }else{
                                    dp[j][i] = arr[j][i] + dp[0][i-1] + dp[1][i-2];
                                }
                            }
                        } else{
                            dp[j][i] = arr[j][i];
                        }
                    }
                }
            }
//
            if(dp[0][N-1] < dp[1][N-1]){
                sb.append(dp[1][N-1]);
            }else{
                sb.append(dp[0][N-1]);
            }
            sb.append("\n");
        }
//        System.out.println(log);
        System.out.println(sb);

        br.close();
    }
}
//          10
//        1 2 3 4 5 6 7 8 9 10
//        2 1 2 1 2 1 3 2 3 20
//        49

// 1 4 3 10 5 18 7 29 9 42
// 2 2 2  7 2 13 3 22 3 51