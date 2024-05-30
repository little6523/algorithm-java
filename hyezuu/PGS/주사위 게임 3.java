import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(a, 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);

        if (map.size() == 1) {
            return 1111 * a;
        } else if (map.size() == 4) {
            return Math.min(a, Math.min(b, Math.min(c, d)));
        } else if (map.size() == 3) {
            int answer = 1;
            for (int key : map.keySet()) {
                if (map.get(key) != 2) {
                    answer *= key;
                }
            }
            return answer;
        } else {
            if (map.get(a) == 2) {
                int[] tmp = new int[2];
                int idx = 0;
                for (int key : map.keySet()) {
                    tmp[idx++] = key;
                }
                int max = Math.max(tmp[0], tmp[1]);
                int min = Math.min(tmp[0], tmp[1]);
                return max * max - min * min;
            } else {
                int answer = 0;
                for (int key : map.keySet()) {
                    answer += map.get(key) == 3 ? key * 10 : key;
                }
                return answer*answer;
            }
        }
    }
}
