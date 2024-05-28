class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        
        int abc = a + b + c;
        int abc2 = a * a + b * b + c * c;
        int abc3 = a * a * a + b * b * b + c * c * c;
        
        if (a == b && b == c)   answer = abc * abc2 * abc3;
        else if (a != b && b != c && c != a)    answer = abc;
        else    answer = abc * abc2;
        
        return answer;
    }
}