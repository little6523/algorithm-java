import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> resultList = new ArrayList<>();

        int multiplier = 1;
        for (int i = 0; i < 10; i++) {
            resultList.add(0);
        }

        for (int i = 0; i < 3; i++) {
            multiplier *= Integer.parseInt(br.readLine());
        }

        String[] strs = (multiplier+"").split("");

        for(String str : strs)
        {
            int temp = Integer.parseInt(str);
            resultList.set(temp, resultList.get(temp)+1);
        }

        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }
    }
}