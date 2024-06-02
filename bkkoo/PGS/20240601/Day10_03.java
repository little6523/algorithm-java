public class Day10_03 {
    public String solution(String my_string, int s, int e) {
        StringBuilder builder = new StringBuilder();
        StringBuilder reverse = new StringBuilder();

        builder.append(my_string, 0, s);
        reverse.append(my_string, s, e + 1);
        builder.append(reverse.reverse());
        builder.append(my_string, e + 1, my_string.length());

        return builder.toString();
    }
}
