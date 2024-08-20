import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        myString = myString.toUpperCase();
        pat = pat.toUpperCase();
        int answer = 0;
        
        if(myString.contains(pat) == true) {
            return answer += 1;
        } else {
            return answer;
        }
    }
}
