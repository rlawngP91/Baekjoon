package dynamicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjon1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        if (N < 3){
            dp = new int[4];
        }
        StringBuilder st = new StringBuilder();

        // 1 - 0
        // 2 - 1
        // 3 - 1
        // 4 - 2 (2로 나누고 2의 값(1))
        // 5 - 3 (1 빼고 4의 값(2)) : 홀수라면 =  1+바로 앞에 있는 숫자의 최솟값
        // 6 - 2 (3으로 나누고 2의 값(1))
        // 7 - 3 (1 빼고 6의 값(2))
        // 8 - 3 (2 로 나누고 4의 값(2))
        // 9 - 2 (3으로 나누고  3의 값(1)) 이거말고
        //10 - 3 (1 빼고 9의 값(2))
        //11 - 4 (1 빼고 10의 값(3))
        //12 - 3 (2으로 나누고 6의 값(2))

        // 2와 3으로 나누어지지 않는 경우 -> 1을 빼고 그 값을 더하기
        // 2와 3으로 나눠지는 경우 -> 둘 다 해보고 작은 수 출력 예외 10

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4; i <= N; i++){
            // 1 빼고 바로 전의 결과값 더하기
            int result = 1 + dp[i-1];
            if((i%3) == 0){
                int temp = 1 + dp[i/3];
                if(temp < result){
                    result = temp;
                }
            }
            if((i%2) == 0) {
                int temp = 1 + dp[i/2];
                if(temp < result){
                    result = temp;
                }
            }
            dp[i] = result;
        }
        st.append(dp[N]);

//        for (int i = 0; i < N; i++) {
//            list.append()
//        }

        System.out.print(st);

        br.close();
    }
}
