import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> m = new HashMap<>();
        for (String[] str : clothes) {
            String type = str[1];
            m.put(type, m.getOrDefault(type, 0) + 1);
        }
        
        for (int count : m.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}