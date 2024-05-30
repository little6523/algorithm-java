import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day07_02 {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = l; i <= r; i++) {
            String temp =Integer.toString(i);
            if ((i + "").matches("[05]+")) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[list.size()];
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
