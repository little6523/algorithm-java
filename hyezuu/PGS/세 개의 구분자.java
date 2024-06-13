import java.util.Arrays;
class Solution {
    public String[] solution(String myStr) {
        String[] arr = Arrays.stream(myStr.split("[a|b|c]+"))
            .filter(x -> !x.isEmpty())
            .toArray(String[]::new);
        
        return arr.length<1 ? new String[]{"EMPTY"} : arr;
        
//         myStr = myStr.replaceAll("[a|b|c]+", ",");
//         myStr = myStr.charAt(0) == ',' ? myStr.substring(1) : myStr;
//         myStr = myStr.equals("") ? "EMPTY" : myStr;

//         return myStr.split("[,]");
    }
}
