public class Day15_05 {
    public static void main(String[] args) {
        String main = "ABC";
        String sub = "abc";

        System.out.printf(""+main.contains(sub));

    }

    public int solution(String myString, String pat) {
        return myString.toLowerCase().contains(pat.toLowerCase()) ? 1 : 0;
    }
}
