import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = {};
        ArrayList<Integer> v = new ArrayList<>();
        
        for (int[] range : intervals) {
            for (int i = range[0]; i < range[1] + 1; i++) {
                v.add(arr[i]);
            }
        }
        
        answer = v.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}