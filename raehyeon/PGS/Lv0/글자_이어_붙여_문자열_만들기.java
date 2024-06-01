import java.util.*;

class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        ArrayList<String> al = new ArrayList<>();
        
        for(int i=0; i<index_list.length; i++) {
            al.add(String.valueOf(my_string.charAt(index_list[i])));
        }
        
        for(int j=0; j<al.size(); j++) {
            answer += al.get(j);
        }
        return answer;
    }
}
