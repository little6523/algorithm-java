import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for (String str : strArr)   m.put(str.length(), m.getOrDefault(str.length(), 0) + 1);
        
        return Collections.max(m.values());
    }
}