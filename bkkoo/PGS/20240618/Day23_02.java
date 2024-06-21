package Day23;

public class Day23_02 {
    public String solution(String[] str_list, String ex) {
        StringBuilder builder = new StringBuilder();

        for (String str : str_list) {
            if (!str.contains(ex)) {
                builder.append(str);
            }
        }
        return builder.toString();
    }
}
