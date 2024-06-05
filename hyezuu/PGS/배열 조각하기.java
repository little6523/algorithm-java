import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int s = 0;
        int e = arr.length-1;
        
        for(int i=0; i<query.length; i++){
            if(i%2==0) e = s + query[i];
            else s += query[i];
        }
        int[] answer = new int[e-s+1];
        System.arraycopy(arr, s, answer, 0, e-s+1);
        
        return answer;
    }
}
