import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int lt= 0;
        int rt= arr.length-1;
        
        int s = -1;
        int e = -1;
        while(lt<rt){
            if(arr[lt]==2 && s == -1){
                s = lt;
            }
            if(arr[rt]==2 && e == -1){
                e = rt;
            }
            if(s>0 && e>0) break;
            lt++;
            rt--;
        }
        if(s<0 && e<0) return new int[]{-1};
        
        s = s<0 ? e: s;
        e = e<0 ? s: e;
        
        int[] answer = new int[e-s+1];
        System.arraycopy(arr , s , answer, 0 , e-s+1);      
        
        return answer;
    }
}
