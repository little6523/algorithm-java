import java.util.*;

class Solution {
    //리스트 풀이
    public int[] solutionByList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        while(i<arr.length){
            int last = list.size()-1;
            if(last<0||list.get(last)<arr[i]) list.add(arr[i++]);
            else list.remove(last);
        } 
        return list.stream().mapToInt(j->j).toArray();
    }
}
    //스택 풀이
    public int[] solutionByStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i<arr.length){
            if(stack.isEmpty()||stack.peek()<arr[i]) stack.push(arr[i++]);
            else stack.pop();
        }     
        int[] stk = new int[stack.size()];
        int idx = 0;
        for(int k : stack){
            stk[idx++] = k;
        }
        return stk;
    }
