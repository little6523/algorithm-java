import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int[] answer = new int[2];
        
        for(int a : num_list){
            if(a%2==0) answer[0]=answer[0]*10+a;
            else answer[1]=answer[1]*10+a;
        }
        return answer[0]+answer[1];
    }
}
