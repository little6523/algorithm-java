package Day20;

import java.util.Arrays;

public class Day20_05 {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);

        return Arrays.copyOfRange(num_list, 0, 5);
    }
}
