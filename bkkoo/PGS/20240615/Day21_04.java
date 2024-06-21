package Day21;

public class Day21_04 {
    public int solution(String num_str) {
        String[] inputs = num_str.split("");
        int answer = 0;
        for(String str : inputs)
        {
            answer += Integer.parseInt(str);
        }
        return answer;
    }
}
