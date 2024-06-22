import java.util.ArrayList;
import java.util.List;

class Solution {
  public String[] solution(String[] todo_list, boolean[] finished) {

    List<Pair<String, Boolean>> list = new ArrayList<>();

    for (int i = 0; i < todo_list.length; i++) {
      list.add(new Pair<>(todo_list[i], finished[i]));
    }

    return list.stream().filter(pair -> !pair.getSecond()).map(Pair::getFirst).toArray(String[]::new);
  }
}

class Pair<T, V> {

  private final T first;
  private final V second;

  public Pair(T first, V second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public V getSecond() {
    return second;
  }
}