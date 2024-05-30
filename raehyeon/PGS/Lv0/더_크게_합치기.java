class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String c = Integer.toString(a) + Integer.toString(b);
        String d = Integer.toString(b) + Integer.toString(a);
        int e = Integer.parseInt(c);
        int f = Integer.parseInt(d);
        
        if(e > f) {
            answer = e;
        } else {
            answer = f;
        }
        return answer;
    }
}
