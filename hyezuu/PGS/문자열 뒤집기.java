class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        int tmp = e;
        for(int i=0; i<my_string.length(); i++){
            sb.append(my_string.charAt(i>=s && i<=e ? tmp-- : i));
        }
        return sb.toString();
        // StringBuilder answer = new StringBuilder(my_string.substring(s, e + 1));
        // answer.reverse();
        // return my_string.substring(0, s) + answer + my_string.substring(e + 1);
    }
}
