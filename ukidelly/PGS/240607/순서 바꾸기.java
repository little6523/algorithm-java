import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
  public int[] solution(int[] numList, int n) {
    ArrayList<Integer> list = new ArrayList<>();
    Arrays.stream(numList).forEach(list::add);

    List<Integer> front = list.subList(0, n);
    List<Integer> back = list.subList(n, list.size());

    back.addAll(front);

    return back.stream().mapToInt(i -> i).toArray();
  }
}