class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int m = 10000001;
            for (int j = queries[i][0]; j <= queries[i][1]; j++)
                if (arr[j] > queries[i][2]) m = Math.min(m, arr[j]);
            if (m == 10000001)  answer[i] = -1;
            else    answer[i] = m;
        }
        return answer;
    }
}