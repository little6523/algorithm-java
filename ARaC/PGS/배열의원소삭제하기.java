import java.util.*;
class Solution {
    public List solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        for(int tmp : arr){
            answer.add(tmp);
        }
        
        for(int tmp : delete_list){
            int check = answer.indexOf(tmp);
            if(check != -1){
                answer.remove(Integer.valueOf(tmp));
            }
        }
        return answer;
    }
}
