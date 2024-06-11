import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};
        String[] tmp = my_string.split(" ");
        ArrayList<String> v = new ArrayList<>();
        
        for (String str : tmp) {
            if (str.equals(""))    continue;
            v.add(str);
        }
        
        answer = v.stream().toArray(String[]::new);
        
        return answer;
    }
}