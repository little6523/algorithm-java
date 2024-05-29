class Solution {
    public int solution(int a, int b) {
        int len = (int)Math.log10(b)+1;
        return Math.max(a*(int)Math.pow(10,len)+b,2*a*b);
    }
}
