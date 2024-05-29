import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] answer = {};
        ArrayList<Integer> vector = new ArrayList<>();
        
        for (int i = start_num; i <= end_num; i++)  vector.add(i);
        
        answer = vector.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}