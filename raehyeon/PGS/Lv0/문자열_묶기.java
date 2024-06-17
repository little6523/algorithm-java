import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] length = new int[31];

        for(int i=0; i<strArr.length; i++) {
            length[strArr[i].length()]++;
        }

        for(int i=0; i<=30; i++) {
            answer = Math.max(answer, length[i]);
        }

        return answer;
    }
}
