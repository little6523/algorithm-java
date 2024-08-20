import java.util.Arrays;

public class Day13_02 {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int[] front = Arrays.copyOfRange(num_list, n, num_list.length);
        int[] back = Arrays.copyOfRange(num_list, 0, n);

        System.arraycopy(front,0, answer,0, front.length);
        System.arraycopy(back,0, answer,front.length, back.length);

        return answer;
    }
}
