import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1); // 배열 초기화
        
        for(int j=0; j<queries.length; j++) {
            int s = queries[j][0];
            int e = queries[j][1];
            int k = queries[j][2];
            
            for(int i=s; i<=e; i++) {
                if(arr[i] > k) {
                    // answer[j]가 -1이라면(초기화 상태 그대로라면) answer[j] = arr[i], 아니라면 answer[j]와 arr[i] 중에서 작은 값이 answer[j]가 된다.
                    answer[j] = answer[j] == -1 ? arr[i] : Math.min(answer[j], arr[i]);
                }
            }
        }
        return answer;
    }
}
