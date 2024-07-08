package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * [공통 문제]
 * 골드 5 AC
 * 입력 문자열을 가공하고 정수형 ArrayDeque로 변환하여 진행했습니다.
 *
 * R 커맨드 입력시
   * 반전 함수의 경우 시간복잡도가 O(N)이기 때문에 여러번 사용되지 않도록 플래그를 활용해 반전된 상태를 나타냈습니다.
 * D 커맨드 입력시
   * 문제 요구사항대로 비어있을 때 에러를 출력하기 위해 에러 플래그를 true로 전환후 break로 커맨드실행을 중단합니다.
   * 반전 플래그가 true인 경우 removeLast()를, 아닌 경우 removeFirst()를 사용했습니다.
 * 풀이시 헤맸던 부분
   * 배열 출력 시 StringBuilder를 사용하지 않고 하나하나 출력해 부하가 걸렸습니다.
   * 처음 배열 입력 받을 때, 비어있거나 원소가 하나라 ,가 없을 경우 split(",")사용시 "" 문자열이 포함돼 원활한 동작이 되지 않았습니다.
 */
public class G5_5430 {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static void printDeque(Deque<Integer> deque, boolean isReversed) throws IOException {
    StringBuilder sb = new StringBuilder("[");
    while (!deque.isEmpty()) {
      sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
      if (!deque.isEmpty()) {
        sb.append(",");
      }
    }
    sb.append("]\n");
    bw.write(sb.toString());
  }

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    while (n-- > 0) {
      var commandArr = br.readLine().toCharArray();
      var isReversed = false;
      var isError = false;
      br.readLine();
      String[] arrStr = br.readLine().replaceAll("\\[", "").replaceAll("]", "").split(",");
      Deque<Integer> strings = Arrays.stream(arrStr).filter(a->!"".equals(a)).map(Integer::parseInt)
          .collect(Collectors.toCollection(ArrayDeque::new));
      for (char c : commandArr) {
        if (c == 'R') {
          isReversed = !isReversed;
        } else if (c == 'D') {
          if (strings.isEmpty()) {
            isError = true;
            break;
          }
          if (isReversed) {
            strings.removeLast();
          } else {
            strings.removeFirst();
          }
        }
      }
      if (isError) {
        bw.write("error\n");
        continue;
      }
      printDeque(strings, isReversed);
    }
    bw.flush();
    br.close();
    bw.close();
  }
}
