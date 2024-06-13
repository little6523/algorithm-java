import java.util.ArrayList;

public class Day19_05 {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (list.contains(i)) {
                continue;
            }
            if (list.size() == k) {
                continue;
            }
            list.add(i);
        }

        while (list.size() < k) {
            list.add(-1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
