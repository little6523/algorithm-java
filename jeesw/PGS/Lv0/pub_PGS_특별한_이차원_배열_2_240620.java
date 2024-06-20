class Solution {
    public int solution(int[][] arr) {
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[i].length; j++) {
                cnt++;
                if (arr[i][j] == arr[j][i])
                    answer++;
            }
        }
        
        return cnt == answer ? 1 : 0;
    }
}