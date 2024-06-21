import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] str = myStr.split("[a-c]+");
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i=0; i<str.length; i++) {
            if(!str[i].equals("")) {
                answer.add(str[i]);
            }
        }
        
        if(answer.size() == 0) {
            answer.add("EMPTY");
        }
        
        return answer.toArray(new String[0]);
    }
}
