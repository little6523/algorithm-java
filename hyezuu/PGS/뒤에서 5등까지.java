import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        
        return Arrays.copyOfRange(num_list, 0, 5);
        // int[] answer = new int[5];
        // Arrays.sort(num_list);
        // System.arraycopy(num_list,0,answer,0,5);
        // return answer;
    }
}
