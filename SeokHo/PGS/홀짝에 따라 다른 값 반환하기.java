class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int square = 0;
        
        if (n % 2 == 0) {
            for(int i = 1; i <= n; i++){
                if(i % 2 != 0) continue;
                square = square + (int) Math.pow(i, 2);
            }
            answer = square;
        }else {
            for(int i = 1; i <= n; i++){
                if(i % 2 == 0) continue;
                sum += i;
            }
            answer = sum;
        }
        
        
        return answer;
    }
}
