import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            // 1, 2, 3의 수로 조합찾기
            // N은 11보다 작음
            int[] arr = new int[12];
            // sol1) 11개의 int배열을 만들고 그냥 값을 계산해서 넣기

            // sol2) 직접 구현 ( 숫자 3만으로 더했을때 나올 수 있는 경우의 수 먼저 구하기 )
            // 3 + 3 => 3+3, 1+2+3, 2+1+3, 1+2+2+1, 1+2+1+2, 2+1+1+2, 2+1+2+1, 1+1+1+3, 1+1+1+1+2, 1+1+1+2+1, 1+1+1+1+1+1,
            // 3+3, 3+1+2, 3+2+1, 2+1+1+2, 2+1+2+1, 1+2+1+2,
            // (3, 1+2, 2+1, 1+1+1) * (3, 1+2, 2+1, 1+1+1)
            // 3 + 3 + 1 => 3+3 경우의 수 x (t -1)
            // 3 + 3 + 2 => 3+3 경우의 수 x (t -1), 3+3 경우의 수 x (t+1) x t

            // 1 - 1
            // 2 - 2 (1 + 1)
            // 3 - 4 (1 + 2 + 1)
            // 4 - 7 (1 + 3 + 3)
            // 5 - 14 (1 + 4 + 6 + 2)
            // 6 - 23 (1 + 5 + 9 + 7 + 1)
            // 1+2+3, 2+2+2

            StringBuilder log = new StringBuilder();

            // range ~ N 까지의 자리 수를 더할 수 있음
            // ex) 7 -> _+_+_ ~ _+_+_+_+_+_+_


        }
        System.out.println(sb);
        br.close();
    }
    private static int getCount(int size, int index){
        if (size == index) {

        }
        return 0;
    }
}
