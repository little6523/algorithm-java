public class Day16_04 {
    public String solution(String myString) {

        myString = myString.toLowerCase();
        myString = myString.replaceAll("a", "A");

        return myString;
    }
}
