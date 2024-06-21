class Solution {
    public int[][] solution(int[][] arr) {
        
        int row = arr.length;
        int col = arr[0].length;
        int longSize = row > col ? row : col;
        
        int[][] answer = new int[longSize][longSize];
        
        for(int i = 0; i < longSize; i++){
            for(int j = 0; j < longSize; j++){
                if(i < row && j < col){
                    answer[i][j] = arr[i][j];
                }else{
                    answer[i][j] = 0;
                }
                    
            }
        }
        
        return answer;
    }
}
