import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        ArrayList<Integer> v = new ArrayList<>();
        Set<Integer> s = new HashSet<Integer>();
        
        for (int num : arr) s.add(num);
        
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (s.contains(arr[i])) {
                v.add(arr[i]);
                s.remove(arr[i]);
                cnt++;
                if (cnt == k) break;
            }
        }

        for (int i = v.size(); i < k; i++)  v.add(-1);
        
        answer = v.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}