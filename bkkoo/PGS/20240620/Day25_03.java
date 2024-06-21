package Day25;

import java.util.Arrays;

public class Day25_03 {
    public int[][] solution(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int size = Math.max(row, col);

        int[][] answer = new int[size][size];

        for (int i = 0; i < row; i++) {
            answer[i] = Arrays.copyOf(arr[i],size);
        }

        return answer;
    }
}
