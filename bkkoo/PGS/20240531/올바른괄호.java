import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        char[] input = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (char ch : input) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
