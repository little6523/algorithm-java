import java.util.*;

class Solution {
    public String[] solution(String myString) {
        return Arrays.stream(myString.split("x"))
            .filter(x -> !x.isEmpty())
            .sorted()
            .toArray(String[]::new);

        // StringTokenizer stk = new StringTokenizer(myString,"x");
        // int len = stk.countTokens(), idx=0;
        // String[] answer = new String[len];
        // for(int i=0; i<len; i++){
        //     answer[idx++]=stk.nextToken();
        // }
        // Arrays.sort(answer);
        // return answer;
    }
}
