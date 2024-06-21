public class Day17_01 {
    public String solution(String myString, String pat) {
        return myString.substring(0, myString.lastIndexOf(pat)) + pat;
    }
}
