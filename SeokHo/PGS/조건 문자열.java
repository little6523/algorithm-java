// 아... 문자열에서 비교는 equals....  까먹고 그냥 비교했다가 한참 걸렸다...
// 오늘도 수업에서 강사님이 물어보셨는데... 정신 차려라 my self 

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;

        if (eq.equals("=")) {
            if (ineq.equals("<")) {
                answer = (n <= m) ? 1 : 0;           
            }else{
                answer = (n >= m) ? 1 : 0;
            }
        }else{
            if (ineq.equals("<")) {
                answer = (n < m) ? 1 : 0;
            }else {
                answer = (n > m) ? 1 : 0;
            }
        }

        return answer;
    }
}
