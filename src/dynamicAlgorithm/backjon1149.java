package dynamicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class backjon1149 {

    //1149
    //다이내믹 알고리즘
    private static int[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int min = 0;
        path = new int[N][3]; // 각각의 RGB의 값에 따라 정해지는 path의 weight
        int[][] weight = new int[N][3];
        for (int i = 0; i < N; i++) {
            int[] temp = new int[3];
            String line = br.readLine();
            String[] t = line.split(" ");
            for (int j = 0; j < 3; j++) {
                temp[j] = Integer.parseInt(t[j]);
            }
            weight[i] = temp;
        }
        // weight[][]
        // 행 : i번째 , 열 : RGB 중 하나를 선택했을 때
        // 값 : i번째에 RGB 중 하나를 선택하게 되면 가지게 되는 가중치의 값

        // 초기값 설정
        for (int i = 0; i < 3; i++) {
            path[0][i] = weight[0][i];
        }
        //R = 0, G = 1, B = 2
        for (int i = 1; i < N; i++) {
            // 현재 i번째 길을 결정함
            for (int j = 0; j < 3; j++) {
                // RGB 각각을 선택했을 때 가질 수 있는 가중치의 최솟값을 path에 넣자
                if (j==0){  //R
                    if (path[i-1][1]< path[i-1][2]){
                        path[i][j] = weight[i][j] + path[i-1][1];
                    }else {
                        path[i][j] = weight[i][j] + path[i-1][2];
                    }
                }
                if (j==1){  //G
                    if (path[i-1][0]< path[i-1][2]){
                        path[i][j] = weight[i][j] + path[i-1][0];
                    }else {
                        path[i][j] = weight[i][j] + path[i-1][2];
                    }
                }
                if (j==2){  //B
                    if (path[i-1][0]< path[i-1][1]){
                        path[i][j] = weight[i][j] + path[i-1][0];
                    }
                    else {
                        path[i][j] = weight[i][j] + path[i-1][1];
                    }
                }
            }
        }
        StringBuilder pathLog = new StringBuilder();
        pathLog.append(min(min(path[N-1][0], path[N-1][1]), path[N-1][2])).append("\n");
        System.out.println(pathLog);
        br.close();
    }
}
