import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (int num : numLog) {
            switch(num - prev) {
                case 1:
                    sb.append('w');
                    break;
                case -1:
                    sb.append('s');
                    break;
                case 10:
                    sb.append('d');
                    break;
                case -10:
                    sb.append('a');
                    break;
                default:
                    break;
            }
            prev = num;
        } 
        answer = sb.toString();
        return answer;
    }
}