import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
       
        for(int i=1; i<Math.pow(2,6); i++){
            int num = Integer.parseInt(Integer.toBinaryString(i))*5;
            if(num > r) break;
            if(num >=l) list.add(num);
        }
        return list.isEmpty()? new int[]{-1} : list.stream().mapToInt(i->i).toArray();
    }
}
