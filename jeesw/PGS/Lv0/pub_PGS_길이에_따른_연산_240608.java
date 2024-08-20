import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        if (num_list.length >= 11) {
            answer = Arrays.stream(num_list).skip(0).limit(num_list.length).sum();
        }
        else {
            answer = Arrays.stream(num_list).skip(0).limit(num_list.length).reduce(1, (a, b) -> a * b);
        }
        
        return answer;
    }
}