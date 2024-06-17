import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list, 5, num_list.length);

        // int[] answer = new int[num_list.length-5];
        // Arrays.sort(num_list);
        // System.arraycopy(num_list,5,answer,0,num_list.length-5);
        // return answer;
    }
}
