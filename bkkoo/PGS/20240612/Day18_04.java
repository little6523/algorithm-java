public class Day18_04 {
    public int solution(String myString, String pat) {
        myString = myString.replaceAll("B", "C");
        myString = myString.replaceAll("A", "B");
        myString = myString.replaceAll("C", "A");


        return myString.contains(pat) ? 1 : 0;
    }
}
