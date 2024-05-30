class Solution {
    public int solution(String number) {   
        int sum = 0;
		for(int i=0; i<number.length(); i++) {
			//sum+= number.charAt(i)-'0';
			sum += Character.getNumericValue(number.charAt(i));
            //숫자형태의 char타입을 int타입으로 변환
            
		}
        int answer = sum%9;
        return answer;
    }
}
