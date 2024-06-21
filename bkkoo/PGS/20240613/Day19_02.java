import java.util.ArrayList;

public class Day19_02 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            for (int index = 0; index < i; index++) {
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
