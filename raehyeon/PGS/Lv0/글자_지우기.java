import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        Arrays.sort(indices);
        
        StringBuffer sb = new StringBuffer(my_string);
        for(int i=0; i<indices.length; i++) {
            sb.deleteCharAt(indices[i] - i);
            answer = sb.toString();
        }
        
        return answer;
    }
}
