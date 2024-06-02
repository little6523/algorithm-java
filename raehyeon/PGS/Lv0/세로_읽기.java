class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++) {
            if((i % m) + 1 == c) {
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }
}
