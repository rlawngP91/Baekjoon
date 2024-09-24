import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon18870 {

    // 18870 1920 11399 1931  1003 1463

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();    // 출력을 위한 builder

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            list.add(input);
            list2.add(input);
        }
        Collections.sort(list2);

        Map<Integer, Integer> map = new HashMap<>();
        int flag = 0;
        for(int i = 0; i < list2.size(); i++){
            if (map.containsKey(list2.get(i))){
                flag++;
            }
            if (flag!=0 && map.containsKey(list2.get(i))){
                continue;
            }
            if (flag!=0){
                map.put(list2.get(i), i+flag);
                continue;
            }
            map.put(list2.get(i), i);
        }


        // 순위매기기
        for (int i = 0; i < N; i++) {
        }
        for (int i = 0; i < list.size(); i++) {
            builder.append(map.get(list.get(i))).append(" ");
        }
        System.out.println(builder);
        br.close();
    }

}

