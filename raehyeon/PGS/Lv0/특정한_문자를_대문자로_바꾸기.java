class Solution {
    public String solution(String my_string, String alp) {
        String answer = my_string;
        char c1 = alp.charAt(0);
        
        for(int i=0; i<my_string.length(); i++) {
            char c2 = my_string.charAt(i);
            String s1 = String.valueOf(c2);
            String s2 = alp.toUpperCase();
            
            if(c1 == c2) {
                answer = answer.replace(s1, s2);
            }
        }
        
        return answer;
    }
}
