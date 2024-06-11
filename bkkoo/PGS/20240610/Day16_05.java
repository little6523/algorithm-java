public class Day16_05 {
    public String solution(String my_string, String alp) {
        return my_string.replaceAll(alp, alp.toUpperCase());
    }
}
