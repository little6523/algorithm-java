class Solution {
    public String solution(String a, String b) {
        StringBuilder sa = new StringBuilder(a).reverse();
        StringBuilder sb = new StringBuilder(b).reverse();
        
        int carry = 0;
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < Math.max(sa.length(), sb.length()); i++) {
            int na = (i < sa.length()) ? Character.digit(sa.charAt(i), 10) : 0;
            int nb = (i < sb.length()) ? Character.digit(sb.charAt(i), 10) : 0;
            
            int sum = na + nb + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        
        if (carry != 0) res.append(carry);
        
        return res.reverse().toString();
    }
}