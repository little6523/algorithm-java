import java.util.ArrayList;

public class Day12_03 {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = intervals[0][0]; i <= intervals[0][1]; i++) {
            list.add(arr[i]);
        }
        for (int i = intervals[1][0]; i <= intervals[1][1]; i++) {
            list.add(arr[i]);
        }

        int idx = 0;
        int[] answer = new int[list.size()];
        for (int i : list) {
            answer[idx++] = i;
        }

        return answer;
    }
}
