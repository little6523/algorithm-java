import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> v = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            boolean b = true;
            for (int j = 0; j < delete_list.length; j++) {
                if (arr[i] == delete_list[j]) {
                    b = false;
                    break;
                }
            }
            if (b)  v.add(arr[i]);
        }
        
        return v.stream().mapToInt(i -> i).toArray();
    }
}