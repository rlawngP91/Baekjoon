import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2 x N
        int N = Integer.parseInt(br.readLine());

        // N을 1, 2로 구분해서 경우의 수 구하기
        // ex) N = 5, 1+1+1+1+1, 1+1+1+2, ... , 2+2+1 : 몇개의 경우의 수?

        StringBuilder sb = new StringBuilder();
        int[] arr = new int[1000];
        arr[0] = 1;
        arr[1] = 2;

//        N = N-1;
        for (int i = 2; i < N; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }

        System.out.println(arr[N-1]);
        br.close();
    }

}
