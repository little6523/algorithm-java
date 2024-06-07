import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> v = new ArrayList<>();
        
        int prev = arr[0];
        v.add(prev);
        
        for (int a : arr) {
            if (prev == a)  continue;
            prev = a;
            v.add(a);
        }
        
        answer = v.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}