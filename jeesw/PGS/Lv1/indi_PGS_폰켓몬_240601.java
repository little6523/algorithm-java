// import java.util.*;

// class Solution {
//     public int solution(int[] nums) {
//         int answer = 0;
//         Map<Integer, Integer> m = new HashMap<>();
        
//         for (int n : nums)  m.put(n, m.getOrDefault(n, 0) + 1);
        
//         for (int i = 0; i < nums.length / 2; i++) {
//             int max = 0;
//             int max_idx = 0;
            
//             for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
//                 if (entry.getValue() > max) {
//                     max = entry.getValue();
//                     max_idx = entry.getKey();
//                 }
//             }
        
//             if (max > 0) {
//                 answer++;
//                 m.remove(max_idx);
//             }
//         }
        
//         return answer;
//     }
// }

import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {

            HashSet<Integer> hs = new HashSet<>();

            for(int i =0; i<nums.length;i++) {
                hs.add(nums[i]);
            }

            if(hs.size()>nums.length/2)
                return nums.length/2;

            return hs.size();
    }
}