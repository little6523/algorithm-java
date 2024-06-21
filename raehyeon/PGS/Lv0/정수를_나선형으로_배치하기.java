class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int direction = 0;
        int num = 1; // 1부터 시작해서 n*n까지 증가한다.
        int rowRight = 0; // 왼쪽 → 오른쪽 방향을 채울 때 시작점
        int colDown = n-1; // 위 → 아래 방향을 채울 때 시작점
        int rowLeft = n-1; // 오른쪽 → 왼쪽 방향을 채울 때 시작점
        int colUp = 0; // 아래 → 위 방향을 채울 때 시작점
        
        while(num <= n * n) {
            if(direction == 0) {
                for(int i=0; i<n; i++) {
                    if(answer[rowRight][i] == 0) {
                        answer[rowRight][i] = num;
                        num++;
                    }
                }
                direction++;
                rowRight++;
            } else if(direction == 1) {
                for(int i=0; i<n; i++) {
                    if(answer[i][colDown] == 0) {
                        answer[i][colDown] = num;
                        num++;
                    }
                }
                direction++;
                colDown--;
            } else if(direction == 2) {
                for(int i=n-1; i>=0; i--) {
                    if(answer[rowLeft][i] == 0) {
                        answer[rowLeft][i] = num;
                        num++;
                    }
                }
                direction++;
                rowLeft--;
            } else {
                for(int i=n-1; i>=0; i--) {
                    if(answer[i][colUp] == 0) {
                        answer[i][colUp] = num;
                        num++;
                    }
                }
                direction = 0;
                colUp++;
            }
        }
        
        return answer;
    }
}
