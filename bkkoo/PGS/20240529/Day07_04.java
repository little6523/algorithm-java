import java.util.ArrayList;

public class Day07_04 {
    public static int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        int current = n;
        list.add(current);
        do {
            if (current % 2 == 0) {
                current = current / 2;
            }
            else {
                current = 3 * current + 1;
            }
            System.out.println(current);
            list.add(current);
        } while (current != 1);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
