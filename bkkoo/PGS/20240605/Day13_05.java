public class Day13_05 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 1, 7, 6};
        solution(arr, 4);
    }
    public static int[] solution(int[] num_list, int n) {
        int[] answer = new int[(num_list.length - 1) / n + 1];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = num_list[i * n];
        }

        return answer;
    }
}
