import java.util.*;

class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        ArrayList<String> al = new ArrayList<>();
        for(int i=0; i<parts.length; i++) {
            int s = parts[i][0];
            int e = parts[i][1];
            String word = my_strings[i];
            String word2 = word.substring(s, e+1);
            al.add(word2);
        }
        
        for(int j=0; j<al.size(); j++) {
            answer += al.get(j);
        }
        return answer;
    }
}
