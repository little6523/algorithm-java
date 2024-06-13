import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i]; j++){
                if(flag[i]){
                    list.add(arr[i]);
                    list.add(arr[i]);
                }
                else list.remove(list.size()-1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
        
        // Stack<Integer> stack = new Stack<>();
        // for(int i=0; i<arr.length; i++){
        //     if(flag[i]){
        //         for(int j=0; j<arr[i]*2; j++)stack.push(arr[i]);
        //     }
        //     else 
        //         for(int j=0; j<arr[i]; j++)stack.pop();       
        // }
        // int[] answer = new int[stack.size()];
        // int idx = 0;
        // for(int a : stack){
        //     answer[idx++] = a;
        // }
        // return answer;
    }
}
