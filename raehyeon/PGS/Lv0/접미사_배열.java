import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> al = new ArrayList<>();
        for(int i=0; i<my_string.length(); i++) {
            String str = my_string.substring(i);
            al.add(str);
        }
        Collections.sort(al);
        String[] answer = new String[al.size()];
        for(int j=0; j<al.size(); j++) {
            answer[j] = al.get(j);
        }
        return answer;
    }
}
