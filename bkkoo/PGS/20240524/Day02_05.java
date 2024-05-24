public class Day02_05 {
    public static void main(String[] args) {

    }

    public static String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        answer = my_string.substring(0,s);
        answer += overwrite_string;
        answer += my_string.substring(s + overwrite_string.length());
        return answer;
    }
}
