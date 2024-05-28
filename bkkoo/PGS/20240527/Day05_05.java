public class Day05_05 {
    public static int solution(int[] num_list) {
        double answer = 0;
        int size = num_list.length;

        int oddIdx = 0;
        int evenIdx = 0;
        for (int i = size - 1; i >= 0; i--) {
            int item = num_list[i];
            if (item % 2 == 0) {
                answer += item * Math.pow(10, evenIdx);
                evenIdx++;
            } else {
                answer += item * Math.pow(10, oddIdx);
                oddIdx++;
            }
        }

        return (int) answer;
    }
}
