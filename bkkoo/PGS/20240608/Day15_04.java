public class Day15_04 {
    public int solution(int[] num_list) {
        int answer = 1;

        if(num_list.length >= 11) {
            for (int i : num_list)
            {
                answer += i;
            }
            return answer - 1;
        }
        else
        {
            for (int i : num_list)
            {
                answer *= i;
            }
            return answer;
        }
    }
}
