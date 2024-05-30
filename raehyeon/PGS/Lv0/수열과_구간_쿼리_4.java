class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr.clone();
        
        for(int j=0; j<queries.length; j++) {
            int s = queries[j][0];
            int e = queries[j][1];
            int k = queries[j][2];
            
            for(int i=s; i<=e; i++) {
                if(i % k == 0) {
                    answer[i] += 1;
                }
            }    
        }
        return answer;
    }
}
