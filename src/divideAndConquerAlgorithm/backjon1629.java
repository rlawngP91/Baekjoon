package divideAndConquerAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjon1629 {

    public static void main(String[] args) throws IOException {
        // Divide and Conquer
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//        int A = Integer.parseInt(str[0]);
//        int B = Integer.parseInt(str[1]);
//        int C = Integer.parseInt(str[2]);
//        br.close();

        // A를 B번 곱해서 C로 나눈 나머지 값 구하기
        // 6 4 17 - 17 * 4 = 41
        // 6 36  216  1296 1296x6
        // 6 2 5 4 7
        System.out.println(24%17);
    }
}
