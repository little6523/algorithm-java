import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] arr = new int[101];
        Arrays.fill(arr, -1);
        for(int i=0; i<rank.length; i++){
            if(attendance[i]){
                arr[rank[i]] = i; 
            }
        }
        int k = 10000;
        int answer = 0;
        
        for(int idx : arr){
            if(idx!=-1){
                answer+= k*idx;
                k/=100;
            }
            if(k<0) break;
        }
        
        return answer;
        
//         Map<Integer, Integer> map = new HashMap<>();
//         int answer = 0;        
//         for(int i=0; i<rank.length; i++){
//             map.put(rank[i],i);
//         }
//         Arrays.sort(rank);
//         int cal = 10000;
//       
//         for(int i=0; i<rank.length; i++){
//             int idx = map.get(rank[i]);
//             if(attendance[idx]) {
//                 answer += idx*cal;
//                 cal/=100;
//             }
//             if(cal<1) break;
//         }
//         return answer;
    }
}
