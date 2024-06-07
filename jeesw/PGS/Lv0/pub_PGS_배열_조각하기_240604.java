import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        ArrayList<Integer> v = new ArrayList<>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
        
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                if (query[i] >= v.size() - 1) continue;
                int last = v.size();
                for (int j = query[i] + 1; j < last; j++)   v.remove(query[i] + 1);
            } else {
                if (query[i] <= 0) continue;
                for (int j = 0; j < query[i]; j++)   v.remove(0);
            }
        }
        
        answer = v.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}