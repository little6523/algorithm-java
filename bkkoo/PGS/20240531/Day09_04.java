import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Day09_04 {
    public String[] solution(String my_string) {
        //ArrayList<String> strList = new ArrayList<String>();

        //for (int i = 1; i <= len; i++) {
        //strList.add(my_string.substring(len-i, len));
        //}

        //Collections.sort(strList);

        //String[] answer  = new String[strList.size()];
        //for (int i = 0; i < strList.size(); i++) {
        //    answer[i] = strList.get(i);
        //}

        String[] answer = new String[my_string.length()];
        int len = my_string.length();

        for (int i = 0; i < len; i++) {
            answer[i] = my_string.substring(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
