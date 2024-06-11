import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        ArrayList<Boolean> v = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') v.add(true);
            else if (s.charAt(i) == ')') {
                if (v.isEmpty()) {
                    answer = false;
                    break;
                }
                v.remove(v.size() - 1);
            }
        }
        
        if (!v.isEmpty())   answer = false;

        return answer;
    }
}