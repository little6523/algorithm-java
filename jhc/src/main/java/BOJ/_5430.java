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

public class _5430 {
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
