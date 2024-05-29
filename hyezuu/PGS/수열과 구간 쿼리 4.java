class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] query : queries){  
            int s =query[0], e = query[1], k = query[2];           
            for(int i=s*k; i<=e; i+=k) arr[i]++;
        }
        return arr;  
    }
}
