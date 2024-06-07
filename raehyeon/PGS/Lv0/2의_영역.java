import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 2) {
                al.add(i);
            }
        }
        
        if(al.size() < 1) {
            return new int[]{-1};
        }
        
        int s = al.get(0);
        int e = al.get(al.size() - 1);
        answer = Arrays.copyOfRange(arr, s, e+1);
    
        return answer;
    }
}
