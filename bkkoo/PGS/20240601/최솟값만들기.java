import java.util.Arrays;

public class 최솟값만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        int[] sortedA = A;
        int[] sortedB = B;

        Arrays.sort(sortedA);
        Arrays.sort(sortedB);

        int length = sortedA.length;

        for(int i=0;i<length;i++)
        {
            answer += sortedA[i] * sortedB[length - i - 1];
        }

        return answer;
    }
}
