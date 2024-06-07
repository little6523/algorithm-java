import java.util.Arrays;

class Main {
  /**
   * 드디어 Arrays.copyOfRange를 사용해서 풀었습니다.
   */
  public int[] solution(int[] numList, int n) {
    return Arrays.copyOfRange(numList, 0, n);
  }
}