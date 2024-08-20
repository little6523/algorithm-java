import java.util.*;

class Solution {
    public int[] solution(String myString) {
        int cnt = 0;
        boolean is_x = false;
        ArrayList<Integer> v = new ArrayList<>();
        
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                is_x = true;
                v.add(cnt);
                cnt = 0;
                continue;
            }
            cnt++;
        }
        
        if (is_x)   v.add(cnt);
        
        return v.stream().mapToInt(i->i).toArray();
    }
}