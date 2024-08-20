import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] costDay = new int[progresses.length];
        ArrayList<Integer> cntV = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) costDay[i] = (99 - progresses[i]) / speeds[i] + 1;
        
        int max_val = costDay[0];
        int cnt = 1;
        
        for (int i = 1; i < costDay.length; i++) {
            if (costDay[i] <= max_val)    cnt++;
            else {
                max_val = costDay[i];
                cntV.add(cnt);
                cnt = 1;
            }
        }
        cntV.add(cnt);
        
        answer = cntV.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}