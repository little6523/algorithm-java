import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        if(a % 2 == 0 && b % 2 == 0) {
            return answer = Math.abs(a - b);
        } else if(a % 2 != 0 && b % 2 != 0) {
            return answer = (int)Math.pow(a, 2) + (int)Math.pow(b, 2);
        } else {
            return answer = 2 * (a + b);
        }
    }
}
