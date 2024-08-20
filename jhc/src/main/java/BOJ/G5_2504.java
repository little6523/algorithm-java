package BOJ;

import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class G5_2504 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    char[] input = br.readLine().toCharArray();
    int res = 0;
    int tmp = 1;
    boolean isError = false;
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < input.length; i++) {
      char c = input[i];
      if (c == '(' || c == '[') {
        stack.push(c);
        tmp *= c == '(' ? 2 : 3;
      }
      if (stack.isEmpty()) {
        stack.push('e');
        break;
      } else if (stack.peek() == '(' && c == ')') {
        if (input[i-1] == '(') {
          res += tmp;
        }
        stack.pop();
        tmp /= 2;
      } else if (stack.peek() == '[' && c == ']') {
        if (input[i-1] == '[') {
          res += tmp;
        }
        stack.pop();
        tmp /= 3;
      }
    }
    bw.write(stack.isEmpty() ? String.valueOf(res) : String.valueOf(0));

    bw.flush();
    br.close();
    bw.close();
  }
}
