import java.util.Arrays;

class Solution {
  public int[] solution(int[] arr, int[][] queries) {
    int[] answer = Arrays.copyOf(arr, arr.length);

    for (int[] query : queries) {
      int start = query[0], end = query[1];

      for (int i = start; i <= end; i++) {
        answer[i]++;
      }
    }

    return answer;
  }
}