public class Day14_05 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;

        for (int[] intArr : queries)
        {
            for (int i = intArr[0]; i <= intArr[1]; i++)
            {
                answer[i]++;
            }
        }
        return answer;
    }
}
