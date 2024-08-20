import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        ArrayList<Integer> v = new ArrayList<>();
        
        for (String str : intStrs) {
            int subNum = Integer.parseInt(str.substring(s, s + l));
            if (subNum > k) v.add(subNum);
        }
        
        answer = v.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}