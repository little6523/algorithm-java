import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        ArrayList<Integer> v = new ArrayList<>();        
        
        switch(n) {
            case 1:
                for (int i = 0; i < slicer[1] + 1; i++) v.add(num_list[i]);
                break;
            case 2:
                for (int i = slicer[0]; i < num_list.length; i++)   v.add(num_list[i]);
                break;
            case 3:
                for (int i = slicer[0]; i < slicer[1] + 1; i++) v.add(num_list[i]);
                break;
            case 4:
                for (int i = slicer[0]; i < slicer[1] + 1; i += slicer[2])  v.add(num_list[i]);
                break;
        }
        
        answer = v.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}