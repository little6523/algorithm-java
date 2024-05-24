class Solution {
    public int solution(int a, int b) {
        int lenA = (int)Math.log10(a)+1;
        int lenB = (int)Math.log10(b)+1;
        int c = a*(int)Math.pow(10, lenB)+ b;
        int d = b*(int)Math.pow(10, lenA)+ a;
        return Math.max(c,d);
    }
}
