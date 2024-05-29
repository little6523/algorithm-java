import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        int len = num_list.length;
        for (int i = 0; i < len; i++)   answer[i] = num_list[i];
        answer[len] = answer[len - 1] > answer[len - 2] ? answer[len - 1] - answer[len - 2] : answer[len - 1] * 2;
        
        return answer;
    }
}