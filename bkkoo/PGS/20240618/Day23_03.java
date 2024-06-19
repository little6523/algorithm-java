package Day23;

public class Day23_03 {
    public int solution(int[] num_list, int n) {
        for (int i : num_list) {
            if (i == n) {
                return 1;
            }
        }
        return 0;
    }
}
