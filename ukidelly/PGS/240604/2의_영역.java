import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    // 그냥 단순한 배열을 사용할때 도저히 풀이가 떠오르지 않아서 List로 변환해서 풀이했습니다.
    public List<Integer> solution(int[] arr) {
    List<Integer> list = Arrays.stream(arr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    if (!list.contains(2)) {
      return List.of(-1);
    } else {
      // 다행이 List에는 indexOf(), lastIndexOf() 메소드가 있어서 편하게 구할 수 있었습니다.
      int startIndex = list.indexOf(2);
      int endIndex = list.lastIndexOf(2);

      return list.subList(startIndex, endIndex + 1);
    }
  }
}