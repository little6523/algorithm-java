public class Day09_02 {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder builder = new StringBuilder();

        int index = 0;
        int s = 0;
        int e = 0;
        for (String str : my_strings) {
            s = parts[index][0];
            e = parts[index][1];

            builder.append(str, s, e + 1);
            //builder.append(str.substring(s, e + 1));
            index++;
        }
        return builder.toString();
    }
}
