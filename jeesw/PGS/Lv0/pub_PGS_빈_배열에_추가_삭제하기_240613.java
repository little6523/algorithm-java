import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        int[] answer = {};
        ArrayList<Integer> v = new ArrayList<>();
        
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++)    v.add(arr[i]);
            }
            else {
                for (int j = 0; j < arr[i]; j++)    v.remove(v.size() - 1);
            }
        }
        
        answer = v.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}