import java.util.Arrays;

public class Day13_03 {
    public static void main(String[] args) {
        String[] strList = {"u", "u", "r", "i", "u"};
        solution(strList);
    }

    public static String[] solution(String[] str_list) {
        String[] answer;
        int index = 0;

        for (String str : str_list) {
            if (str.equals("l")) {
                answer = Arrays.copyOfRange(str_list, 0, index);
                return answer;
            } else if (str.equals("r")) {
                answer = Arrays.copyOfRange(str_list, index + 1, str_list.length);
                return answer;
            }
            index++;
        }
        return answer = new String[0];
    }
}
