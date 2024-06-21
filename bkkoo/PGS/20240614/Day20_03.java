package Day20;

import java.util.HashMap;
import java.util.Map;

public class Day20_03 {
    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int length = 0;
        int value = 0;
        for(String str : strArr)
        {
            length = str.length();
            value = map.getOrDefault(length, 0) + 1;
            map.put(length, value);
            answer = Integer.max(answer, value);
        }
        return answer;
    }
}
