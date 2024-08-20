class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        
        for(int k=0; k<arr.length; k++) {
            answer[k] = arr[k];
        }
        
        for(int k=0; k<queries.length; k++) {
            int i = queries[k][0];
            int j = queries[k][1];
            
            int temp = answer[i];
            answer[i] = answer[j];
            answer[j] = temp;
        }
        return answer;
    }
}
