class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int length1 = my_string.length(); // my_string 문자열 길이
        int length2 = overwrite_string.length(); // overwrite_string 문자열 길이
        
        answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s+length2, length1);
        return answer;
    }
}
