package BOJ;

import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 해당문제를 좌에서 우로 진행하는 흐름이라고 생각할 때,
 * 레이저를 한 덩어리로 보고 레이저가 다음 인덱스일 경우 다음과 같이 생각할 수 있다.
 * 좌에서 우로 열린괄호의 개수를 세면서 진행한다. 레이저를 만나면 막대개수에 그 시점 열린괄호의 개수만큼 더한다
 * (------||)이런식으로 막대의 1개 단위가 종결된다고 볼 수 있기 때문이다.
 * 그럼 세고 있던 열린괄호의 개수를 줄일 수 있는 기준은 어떻게 구할까?
  * 여기서 스택을 사용한다. 레이저는 인덱스로 따져 연속된 인덱스일경우 레이저로 판단하고 다음 인덱스는 임의로 넘기고
 * 스택에서는 열린괄호를 만나면 넣고 열린괄호 개수 +1 닫힌 괄호를 만나면 빼고 열린괄호 개수 -1을 한다.
 * 주의할 점은 닫힌괄호일 경우에도 개수로 친다는 것이다. 따라서 스택에서 빼는 시점에 막대 개수 +1을 해준다
 */
public class S2_10799 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

    String input = br.readLine();
    char[] brackets = input.toCharArray();
    int leftC = 0;
    int res = 0;
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < brackets.length; i++) {
      if (i < brackets.length-1 && brackets[i] == '(' && brackets[i+1] == ')') {
        res += leftC;
        i++;
        continue;
      }
      if (brackets[i] == '(') {
        stack.push('(');
        leftC++;
      } else if (!stack.isEmpty() && stack.peek() == '('){
        leftC--;
        res++;
      }
    }
    bw.write(String.valueOf(res));
    bw.flush();
    br.close();
    bw.close();
  }
}
