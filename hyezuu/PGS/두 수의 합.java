class Solution {
    public String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int lenA = a.length();
        int lenB = b.length();
        
        int carry = 0;
        
        for(int i = 1; i <= Math.max(lenA, lenB); i++) {
            int sum = carry;
            if(lenA - i >= 0) {
                sum += a.charAt(lenA - i) - '0';
            }
            if(lenB - i >= 0) {
                sum += b.charAt(lenB - i) - '0';
            }
            carry = sum / 10;
            sb.insert(0, sum % 10);
        }
        if(carry > 0) {
            sb.insert(0, carry);
        }
        
        return sb.toString();
        // return new BigInteger(a).add(new BigInteger(b)) + "";
    }
}
