class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        
        for (int i = 0; i < my_string.length(); i++) {
            if(alp.contains(my_string.substring(i, i + 1)))    answer += my_string.toUpperCase().charAt(i);
            else    answer += my_string.toLowerCase().charAt(i);
        }
        
        return answer;
    }
}