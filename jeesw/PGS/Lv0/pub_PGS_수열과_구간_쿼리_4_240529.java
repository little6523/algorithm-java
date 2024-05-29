class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        
        for (int q = 0; q < queries.length; q++) {
            for (int i = queries[q][0]; i <= queries[q][1]; i++)
                if (i % queries[q][2] == 0) arr[i]++;
        }
        
        answer = arr;
        
        return answer;
    }
}