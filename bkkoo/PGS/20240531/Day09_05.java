public class Day09_05 {
    public int solution(String my_string, String is_suffix) {
        int len = my_string.length();

        for (int i = 0; i < len; i++) {
            if(is_suffix.equals(my_string.substring(i)))
            {
                return 1;
            }
        }
        return 0;
    }
}
