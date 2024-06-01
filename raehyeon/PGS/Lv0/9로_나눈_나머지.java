class Solution {
    public int solution(String number) {
        int answer = 0;
        
        for(int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            int num = Integer.parseInt(String.valueOf(c));
            answer += num;
        }
        
        answer = answer % 9;
        return answer;
    }
}
