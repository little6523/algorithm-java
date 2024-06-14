import java.util.Stack;

public class Day19_04 {
    public static int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<Integer>();

        for (int i : arr) {
            if (stack.isEmpty() || stack.peek() != i) {
                stack.push(i);
            }
            else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return new int[]{-1};
        } else {
            return stack.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
