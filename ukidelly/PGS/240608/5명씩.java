import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 또 리스트를 사용해서 풀었네요 ㅠ
 */
class Solution {
  public String[] solution(String[] names) {
    ArrayList<String> list = new ArrayList<>(Arrays.asList(names));
    List<String> answer = new ArrayList<>(List.of());

    for (int i = 0; i < names.length; i += 5) {
      answer.add(list.get(i));
    }

    return answer.toArray(new String[0]);
  }
}