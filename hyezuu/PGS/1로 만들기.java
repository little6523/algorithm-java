class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int a : num_list){
            answer += Integer.toBinaryString(a).length()-1;
        }
        return answer;
    }
}
