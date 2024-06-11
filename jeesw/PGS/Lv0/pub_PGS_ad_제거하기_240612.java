import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        ArrayList<String> v = new ArrayList<>();
        
        for (String str : strArr) {
            if (str.contains("ad")) continue;
            v.add(str);
        }
        
        answer = v.stream().toArray(String[]::new);
        
        return answer;
    }
}