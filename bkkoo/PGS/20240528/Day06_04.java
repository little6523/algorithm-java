public class Day06_04 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;

        for (int[] query : queries) {
            int x = query[0];
            int y = query[1];

            int temp = arr[x];
            answer[x] = arr[y];
            answer[y] = temp;
        }

        return answer;
    }
}
