import javax.naming.PartialResultException;
import java.util.Arrays;

public class Day06_05 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 3};
        int[][] quer = {{0, 4, 2}, {0, 3, 2}, {0, 2, 2}};
        solution(arr, quer);
    }

    public static int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1);

        for (int queryIdx = 0; queryIdx < queries.length; queryIdx++) {

            int s = queries[queryIdx][0];
            int e = queries[queryIdx][1];
            int k = queries[queryIdx][2];

            for (int i = s; i <= e; i++) {
                if (k < arr[i]) {
                    answer[queryIdx] = answer[queryIdx] == -1 ? arr[i] : Math.min(answer[queryIdx], arr[i]);
                }
            }
        }

        return answer;
    }
}
