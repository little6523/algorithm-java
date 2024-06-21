class Solution {
    public int solution(int a, int b) {
        boolean isAodd = a%2==1;
        boolean isBodd = b%2==1;
        
        if(isAodd && isBodd) return (a*a) + (b*b);
        else if(isAodd || isBodd) return (a+b)*2;
        
        return Math.abs(a-b);
    }
}
