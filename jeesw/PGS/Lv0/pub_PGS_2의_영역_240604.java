import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> v = new ArrayList<>();
        ArrayList<Integer> v2 = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2)    v.add(i);
        }
        
        if (v.isEmpty())    v2.add(-1);
        else {
            int beginIdx = v.get(0), endIdx = v.get(v.size() - 1);

            for (int i = beginIdx; i <= endIdx; i++) {
                v2.add(arr[i]);
            }
        }
        
        answer = v2.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}