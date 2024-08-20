import java.util.*;

class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder(my_string.substring(s, e + 1));
        sb.reverse();
        
        answer = my_string.substring(0, s) + sb.toString() + my_string.substring(e + 1, my_string.length());
        
        return answer;
    }
}