import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(solution(input));
    }

    private static int solution(String input) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int tmp = 1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isLeftBracket(c)) {
                stack.push(c);
                tmp *= (c == '(' ? 2 : 3);
            }
            if (stack.isEmpty()) return 0;
            else if (isSquareBrackets(c, stack.peek())) {
                if (input.charAt(i - 1) == '[') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 3;
            } else if (isParenthesis(c, stack.peek())) {
                if (input.charAt(i - 1) == '(') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 2;
            }
        }
        return stack.isEmpty() ? answer : 0;
    }

    static boolean isLeftBracket(char ch) {
        return ch == '(' || ch == '[';
    }

    static boolean isSquareBrackets(char ch, char ch2) {
        return ch == ']' && ch2 == '[';
    }

    static boolean isParenthesis(char ch, char ch2) {
        return ch == ')' && ch2 == '(';
    }
}
