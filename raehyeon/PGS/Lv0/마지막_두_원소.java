class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        int num1 = num_list[num_list.length-1];
        int num2 = num_list[num_list.length-2];
        
        if(num1 > num2) {
            int num3 = num1 - num2;
            for(int i=0; i<num_list.length; i++) {
                answer[i] = num_list[i];
            }
            answer[num_list.length] = num3;
        } else {
            int num3 = num1 * 2;
            for(int i=0; i<num_list.length; i++) {
                answer[i] = num_list[i];
            }
            answer[num_list.length] = num3;
        }
        return answer;
    }
}
