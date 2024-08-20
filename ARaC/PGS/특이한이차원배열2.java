class Solution {
    public int solution(int[][] arr) {
        int answer = 1;
        int len = arr.length;
        
        for(int i = 0; i<len; i++){
            for(int j = 0; j<len; j++){
                if(arr[i][j] != arr[j][i]){
                    answer = 0;
                }
            }
        }
        return answer;
    }
}
