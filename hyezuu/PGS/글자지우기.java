import java.util.Arrays;

class Solution {
    public String solution(String myString, int[] indices) {
        StringBuilder sb = new StringBuilder(myString);
        for(int i : indices){
            sb.setCharAt(i,' ');
        }
        return sb.toString().replace(" ","");
    }
}
