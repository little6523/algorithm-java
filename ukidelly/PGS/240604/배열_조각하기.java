import java.util.Arrays;

/**
 * 결국 푸는 방법이 생각 안나서 정답을 봤습니다. 그 중 가장 인상적인 정답이더군요.
 * 배열을 실시간으로 자르는 것이 아닌, 시작과 끝 인덱스를 저장하고, 마지막에 Arrays.copyOfRange()로 잘라서 반환하는 방법이었습니다.
 */
class Solution {
  public int[] solution(int[] arr, int[] query) {
    int start = 0;
    int end = arr.length - 1;
    for (int i = 0; i < query.length; i++) {
      if (i % 2 == 0) {
        // i가 짝수일 때, 뒤를 버리는 것이니까, start에서부터 query[i] - 1 인덱스를 제외하고 버림
        end = start + query[i] - 1;
      } else {
        // i가 홀수 이면, start의 위치를 query[i]로 이동
        start += query[i];
      }
    }

    return Arrays.copyOfRange(arr, start, end + 2);
  }
}