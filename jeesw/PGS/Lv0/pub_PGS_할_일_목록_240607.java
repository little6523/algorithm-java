import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        String[] answer = {};
        ArrayList<String> v = new ArrayList<>();
        
        for (int i = 0; i < todo_list.length; i++)  if (!finished[i])   v.add(todo_list[i]);
    
        answer = v.stream().toArray(String[]::new);
        
        return answer;
    }
}