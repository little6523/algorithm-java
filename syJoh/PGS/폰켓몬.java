import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;      
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        //최대한 다양한 종류로 N/2개 
        if(nums.length/2 >= set.size()){ 
            answer = set.size();
        }else{
            answer = nums.length/2;
        }
        return answer;
    }
}
