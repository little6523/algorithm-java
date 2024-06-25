import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> op = new Stack<>();
        
        String expressions = br.readLine();

        for (int i = 0; i < expressions.length(); i++) {
            char c = expressions.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                op.push(c);
            } else if (c == '*' || c == '/') {
                while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
                    sb.append(op.pop());
                }
                op.push(c);
            } else if (c == '+' || c == '-') {
                while (!op.isEmpty() && op.peek() != '(') {
                    sb.append(op.pop());
                }
                op.push(c);
            } else if (c == ')') {
                while (!op.isEmpty() && op.peek() != '(') {
                    sb.append(op.pop());
                }
                op.pop();
            }
        }

        while (!op.isEmpty()) {
            sb.append(op.pop());
        }

        System.out.println(sb);
    }
}