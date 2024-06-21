import java.util.ArrayList;

public class Day17_03 {
    public String[] solution(String[] strArr) {

        ArrayList<String> returnArr = new ArrayList<>();

        for (String str : strArr) {
            if (str.contains("ad")) {
                continue;
            }
            returnArr.add(str);
        }

        String[] answer = new String[returnArr.size()];
        returnArr.toArray(answer);

        return answer;
    }
}
