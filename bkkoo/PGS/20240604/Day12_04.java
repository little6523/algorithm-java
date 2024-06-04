import java.util.Arrays;

public class Day12_04 {

    public int[] solution(int[] arr) {
        int start = -1;
        int end = 0;

        int index = 0;
        for (int i : arr)
        {
            if(i == 2)
            {
                end = index;
                if(start == -1)
                {
                    start = index;
                }
            }
            index ++;
        }

        if(start == -1)
        {
            return new int[]{-1};
        }

        return Arrays.copyOfRange(arr, start, end + 1);
    }
}
