public class Day12_02 {
    public int solution(int[] num_list) {
        int answer = 0;

        for(int i : num_list)
        {
            if(i < 0) {
                return answer;
            }
            answer++;
        }

        return -1;
    }
}
