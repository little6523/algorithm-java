import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(!stack.isEmpty() && stack.peek()==arr[i]) stack.pop();
            else stack.push(arr[i]);
        }
        
        int[] answer = new int[stack.size()];
        
        int idx = 0;
        for(int a : stack){
            answer[idx++] = a;
        }
        
        return answer.length<1 ? new int[]{-1} : answer;
    }

//         Stack<Integer> stack = new Stack<>(); 
        
//         for(int a : arr){
//             if(!stack.isEmpty()&& stack.peek()==a) stack.pop();
//             else stack.push(a);
//         }
        
//         return stack.isEmpty()? new int[]{-1} : stack.stream().mapToInt(i->i).toArray();
//     }
}
