public class Day03_05 {
    public int solution(int a, int b) {
        int case01 = PlusIntegerAsString(a,b);
        int case02 = 2 * a*b;
        return case01 >= case02 ? case01 : case02;
    }

    public int PlusIntegerAsString(int a, int b) {
        StringBuilder builder = new StringBuilder();
        return Integer.parseInt(builder.append(a).append(b).toString());
    }
}
