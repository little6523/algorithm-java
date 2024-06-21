class Solution {
    public int[][] solution(int[][] arr) {
        int len = (arr.length > arr[0].length) ? arr.length : arr[0].length;
        int[][] answer = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr.length - 1 < i)   answer[i][j] = 0;
                else if (arr[0].length - 1 < j) answer[i][j] = 0;
                else    answer[i][j] = arr[i][j];
            }
        }
        
        return answer;
    }
}