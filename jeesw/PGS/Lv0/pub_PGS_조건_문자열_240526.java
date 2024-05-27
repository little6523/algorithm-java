class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        int sum = 0;
        
        if (eq.equals("=")) {
            if (n == m) sum++;
        }
        if (ineq.equals("<")) {
            if (n < m) sum++;
        }
        else {
            if (n > m) sum++;
        }
        
        answer = (sum > 0) ? 1 : 0;
        
        return answer;
    }
}