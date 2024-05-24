class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int center = overwrite_string.length();
        int last = my_string.length();
        
        answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s + center, last);
        
        return answer;
    }
}