class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum = 0;
        int mul = 1;
        int square = 0;
        
        for(int i=0; i<num_list.length; i++) {
            mul *= num_list[i];
            sum += num_list[i];
        }
        square = sum * sum;
        answer = (mul < square) ? 1 : 0;
        return answer;
    }
}
