import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> v = new ArrayList<>();
        
        for (int num : arr) {
            for (int i = 0; i < num; i++) {
                v.add(num);
            }
        }
        
        answer = v.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}