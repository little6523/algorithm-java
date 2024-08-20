import java.util.Arrays;
import java.util.List;

class Main {
  /**
   * 제가 푼 방식
   * 자꾸만 List로 변환해서 풀 생각만 했네요...
   */
  public String[] solution(String[] strList) {
    List<String> list = Arrays.asList(strList);

    for (String str : list) {
      if (str.equals("l")) {
        return list.subList(0, list.indexOf(str)).toArray(new String[0]);

      } else if (str.equals("r")) {
        return list.subList(list.indexOf(str) + 1, list.size()).toArray(new String[0]);
      }
    }

    return new String[0];
  }

  /**
   * 다른 사람이 푼 방식, Arrays.copyOfRange를 사용해서 풀었습니다.
   */
  public String[] solution2(String[] str_list) {

    for (int i = 0; i < str_list.length; i++) {

      if ("l".equals(str_list[i])) {
        return Arrays.copyOfRange(str_list, 0, i);
      } else if ("r".equals(str_list[i])) {
        return Arrays.copyOfRange(str_list, i + 1, str_list.length);
      }
    }

    return new String[0];
  }
}