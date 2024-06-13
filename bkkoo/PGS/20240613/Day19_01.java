import java.util.ArrayList;

public class Day19_01 {
    public String[] solution(String myStr) {
        String[] strArr = myStr.split("[abc]");
        ArrayList<String> strList = new ArrayList();

        for (String str : strArr) {
            if (!str.isEmpty()) {
                strList.add(str);
            }
        }

        if (strList.size() == 0) {
            return new String[]{"EMPTY"};
        }
        else {
            return strList.toArray(new String[0]);
        }
    }
}
