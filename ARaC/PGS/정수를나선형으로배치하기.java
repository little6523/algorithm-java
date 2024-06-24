class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int[] dc = {0,1,0,-1};
        int[] dr = {1,0,-1,0};
        
        int nc = 0;
        int nr = 0;
        answer[nc][nr] = 1;
        int key = 2;
        int dir = 0;
        
        while (key <= (n*n)){
            if(0<=nc+dc[dir] && nc+dc[dir]<n && 0<=nr+dr[dir] && nr+dr[dir] < n 
               && answer[nc+dc[dir]][nr+dr[dir]]==0) {
                nc += dc[dir];
                nr += dr[dir];
                answer[nc][nr] = key;
                key += 1;   
            }else{
                if(dir == 3){
                    dir = 0;
                }else{
                    dir += 1;
                }
            }
        }
            
        return answer;
    }
}
