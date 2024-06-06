import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        
        System.arraycopy(Arrays.copyOfRange(num_list, 0, n), 0, answer, num_list.length - n, n);
        System.arraycopy(Arrays.copyOfRange(num_list, n, num_list.length), 0, answer, 0, num_list.length - n);
        
        return answer;
    }
}