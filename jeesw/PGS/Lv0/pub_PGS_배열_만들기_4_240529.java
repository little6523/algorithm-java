import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (s.empty())   s.push(arr[i]);
            else {
                if(s.peek() < arr[i])    s.push(arr[i]);
                else {
                    i--;
                    s.pop();
                }
            }
        }
        
        stk = s.stream().mapToInt(Integer::intValue).toArray();
        
        return stk;
    }
}