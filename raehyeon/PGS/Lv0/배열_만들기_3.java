import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            for(int j=s; j<=e; j++) {
                al.add(arr[j]);
            }
        }
        
        int[] answer = new int[al.size()];
        for(int k=0; k<al.size(); k++) {
            answer[k] = al.get(k);
        }
        
        return answer;
    }
}
