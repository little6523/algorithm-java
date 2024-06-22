import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int k = 100000000;
        
        while(k > 0){
            if (n / k != 0){
                answer += (n/k);
                n = (n%k);
            }
            k = (k/10);
        }
        return answer;
    }
}
