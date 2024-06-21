// import java.util.Arrays;
// import java.util.stream.Collectors;

class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) < 'l')   sb.append('l');
            else    sb.append(myString.charAt(i));
        }
        
        return sb.toString();
        
        // return myString.codePoints().map(c -> (c < 'l') ? 'l' : c).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
    }
}