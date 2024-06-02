public class Day10_04 {
    public String solution(String my_string, int m, int c) {
        StringBuilder builder = new StringBuilder();

        for (int i = c - 1; i < my_string.length(); i+= m) {
            char temp = my_string.charAt(i);
//            char temp = my_string.charAt(c - 1 + m*i);
            builder.append(temp);
        }

        return builder.toString();
    }
}
