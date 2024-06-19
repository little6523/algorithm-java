import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        int lt= 0;
        int rt = num_list.length-1;
        while(lt<=rt){
            if(num_list[lt]==n || num_list[rt]==n){
                return 1;
            }
            lt++;
            rt--;
        }
        return 0;
    }
}
