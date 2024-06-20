/**
차가운거, 뜨거운거 구분없이
아메리카노, 아무거나: 4500
라때: 5000

삼항연산자 사용해서 음료만 구분해서 더해주자.

**/

class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for (int i = 0; i < order.length; i++) {
			answer += order[i].contains("latte") ? 5000 : 4500;
		}
        return answer;
    }
}