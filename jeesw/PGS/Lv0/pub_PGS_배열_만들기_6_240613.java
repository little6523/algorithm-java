import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> stk = new ArrayList<>();
        
        for (int num : arr) {
            if (stk.isEmpty()) {
                stk.add(num);
                continue;
            }
            if (num == stk.get(stk.size() - 1)) stk.remove(stk.size() - 1);
            else    stk.add(num);
        }
        
        if (stk.isEmpty())  stk.add(-1);
        
        answer = stk.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}