public class Day11_04 {
    public static void main(String[] args) {
        solution(10, 3);
    }
    public static int[] solution(int start, int end_num) {
        int[] answer = new int [start - end_num + 1];
        for (int i = 0; i <= start - end_num; i++) {
            answer[i] = start - i;
        }
        return answer;
    }
}
