package Day20;

public class Day20_02 {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return 1;
        }
        else if (arr1.length < arr2.length) {
            return -1;
        }
        else {
            int sum = 0;

            for (int i = 0; i < arr1.length; i++) {
                sum += arr1[i] - arr2[i];
            }
            if (sum == 0) {
                return 0;
            }
            return sum / Math.abs(sum);
        }
    }
}
