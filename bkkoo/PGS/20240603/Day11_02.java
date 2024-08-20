public class Day11_02 {
    public static void main(String[] args) {
        solution(10, 3);
    }

    public static int[] solution(int n, int k) {
        int[] answer = new int[n/k];

        int index = 0;
        for (int i = k; i <= n; i+=k) {
            answer[index++] = i;
        }

        return answer;
    }
}
