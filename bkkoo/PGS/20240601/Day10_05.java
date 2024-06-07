public class Day10_05 {
    public String solution(int q, int r, String code) {
        StringBuilder builder = new StringBuilder();

        for (int i = r; i < code.length(); i+=q) {
            if(i %q == r)
            {
                builder.append(code.charAt(i));
            }
        }

        return builder.toString();
    }
}
