import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<num_list.length; i+=n) {
            al.add(num_list[i]);
        }
        
        int[] answer = new int[al.size()];
        
        for(int j=0; j<al.size(); j++) {
            answer[j] = al.get(j);
        }
        
        return answer;
    }
}
