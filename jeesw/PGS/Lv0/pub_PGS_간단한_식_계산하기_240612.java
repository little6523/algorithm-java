import java.util.*;

class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        if (binomial.contains(" + ")) {
            answer = Arrays.stream(binomial.split(" \\+ ")).mapToInt(Integer::parseInt).reduce(0, (a, b) -> a + b);
        }
        else if (binomial.contains(" - ")) {
            binomial = "-" + binomial;
            answer = Arrays.stream(binomial.split(" \\- ")).mapToInt(Integer::parseInt).reduce(0, (a, b) -> a - b);
        }
        else if (binomial.contains(" * ")) {
            answer = Arrays.stream(binomial.split(" \\* ")).mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b);
        }
        
        return answer;
    }
}