import java.util.Arrays;

public class Day11_03 {
    public String solution(String my_string, int[] indices) {
        StringBuilder builder = new StringBuilder(my_string);
        Arrays.sort(indices);

        for (int i = 1; i <= indices.length; i++) {
            builder.deleteCharAt(indices[indices.length - i]);
        }

        return builder.toString();
    }
}
