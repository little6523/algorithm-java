import java.util.ArrayList;
import java.util.stream.IntStream;

// IntStream을 써봤는데 뭐랄까... 그냥 for문 쓰는게 더 편한 것 같네요
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {

    ArrayList<Integer> result = new ArrayList<Integer>();

    for (int[] interval : intervals) {
      int left = interval[0];
      int right = interval[1];

      IntStream.rangeClosed(left, right).forEach(i -> result.add(arr[i]));
    }

    return result.stream().mapToInt(i -> i).toArray();
  }
}