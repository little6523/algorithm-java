class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        for(int i=2; i<=number; i++){
            int cnt = 0;
            int root = (int)Math.sqrt(i);
            for(int j=1; j<=root; j++){
                if(i%j==0) cnt++;
            }
            int tmp = cnt*2 - (i==root*root ? 1 :0);
            answer += (limit<tmp? power : tmp);
        }
        return answer;
    }
}