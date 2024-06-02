import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<intStrs.length; i++) {
            String num1 = intStrs[i];
            String str = num1.substring(s, s+l);
            int num2 = Integer.parseInt(str);
            if(num2 > k) {
                al.add(num2);
            }
        }
        
        int[] answer = new int[al.size()];
        for(int i=0; i<al.size(); i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}
