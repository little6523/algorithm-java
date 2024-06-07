public class Day09_03 {
    public String solution(String my_string, int n) {
        StringBuilder builder = new StringBuilder();
        int length = my_string.length();
        builder.append(my_string, length - n, length);
        return builder.toString();
    }
}
