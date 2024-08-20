
class Solution {
    public String solution(String a, String b) {
        String answer = "";
        
        a = reversed(a);
        b = reversed(b);
        //swap
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        
        int zero = a.length()-b.length();
        for(int i = 0; i< zero; i++){
            b += '0';
        }
        
        int carry = 0;
        for(int i = 0; i<a.length(); i++){
            int intSum = (a.charAt(i) - '0') + (b.charAt(i)-'0') + carry;
            
            carry = intSum / 10;
            
            answer += String.valueOf(intSum%10);
        }
        
        if(carry != 0){
            answer += String.valueOf(carry);
        }
        
        answer = reversed(answer);
        
        return answer;
        
    }
    //역순으로 저장하는 함수
    public static String reversed(String str){
        String strReversed = "";
        for(int i = str.length()-1; i >= 0; i--){
            strReversed += str.charAt(i);
        }
        return strReversed;
    }
}
