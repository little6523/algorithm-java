class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] answer = new int[len+1];
        
        System.arraycopy(num_list,0,answer,0,len);
        
        int case1 = num_list[len-1]-num_list[len-2];
        int case2 = num_list[len-1]*2;
        
        answer[len] = case1> 0 ? case1 : case2;
         
        return answer;
    }
}
