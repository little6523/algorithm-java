import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        ArrayList<Integer> vector = new ArrayList<>();
        
        while (n != 1) {
            vector.add(n);
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
        }
        vector.add(1);
        
        answer = vector.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}