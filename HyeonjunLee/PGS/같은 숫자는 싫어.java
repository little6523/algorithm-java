import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        ans.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == stack.peek()) {
                continue;
            } else {
                stack.push(arr[i]);
                ans.add(arr[i]);
            }
        }

        answer = ans.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
