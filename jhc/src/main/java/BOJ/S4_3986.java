package BOJ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 풀이는 맞았으나
 * package (1번라인)을 포함해서 런타임 에러가 계속났다.
 * 다른 사람들은 나중에 주의..
 * 전형적인 스택문제였다! 괄호문제와 풀이는 동일하게 특정조건일때 pop되도록 하는 것이 중요했다.
 */

public class S4_3986 {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws Exception {
    int c = Integer.parseInt(br.readLine());
    int res = 0;
    while (c-- > 0) {
      Stack<Character> stack = new Stack<>();
      String word = br.readLine();
      for(int i = 0; i < word.length(); i++) {
        if (!stack.isEmpty() && stack.peek() == word.charAt(i)) {
          stack.pop();
        } else {
          stack.push(word.charAt(i));
        }
      }
      if (stack.isEmpty()) res++;
    }

    bw.write(String.valueOf(res));

    bw.flush();
    br.close();
    bw.close();
  }
}
