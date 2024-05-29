class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int ab = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        
        answer = (ab >= 2 * a * b) ? ab : 2 * a * b;
        
        return answer;
    }
}