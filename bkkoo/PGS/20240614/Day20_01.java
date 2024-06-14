package Day20;

import java.util.Arrays;

public class Day20_01 {
    public int[] solution(int[] arr) {
        int length = arr.length;
        if ((length & (length - 1)) == 0) {
            return arr;
        }

        for (int i = 1; i < 16; i *= 2) {
            length |= length >> i;
        }
        length++;
        int[] answer = Arrays.copyOfRange(arr, 0, length);


        return answer;
    }
}
