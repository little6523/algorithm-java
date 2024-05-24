public class Day03_04 {
    public static int solution(int a, int b) {
        StringBuilder builder = new StringBuilder();

        int case01 = Integer.parseInt(builder.append(a).append(b).toString());
        builder.setLength(0);
        int case02 = Integer.parseInt(builder.append(b).append(a).toString());


        return case01 > case02 ? case01 : case02;
    }
}

