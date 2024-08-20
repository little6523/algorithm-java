// 1. BFS를 이용하여 풀기.
class Solution {
    public static int[][] answer;
    public static int dirX[] = {0, 1, 0, -1};
    public static int dirY[] = {1, 0, -1, 0};
    
    public int[][] solution(int n) {
        answer = new int[n][n];
        
        bfs(n);

        return answer;
    }
    
    public static void bfs(int size) {
        int x = 0;
        int y = 0;
        int dir = 0;
        int cnt = 1;
        while (cnt <= size * size) {
            answer[x][y] = cnt;

            int newX = x + dirX[dir]; 
            int newY = y + dirY[dir];

            if (newX < 0 || newX >= size || newY < 0 || newY >= size || answer[newX][newY] != 0) {
                dir = (dir + 1) % 4;
                newX = x + dirX[dir];
                newY = y + dirY[dir];
            }
            x = newX;
            y = newY;
            
            cnt++;
        }
        
        return;
    }
}


// 2. DP를 이용하여 풀기
// import java.util.List;
// import java.util.ArrayList;

// class Solution {
//     public static List<Integer>[] dp = new ArrayList[30];

//     public int[][] solution(int n) {
//         int[][] answer = new int[n][n];

//         for (int i = 0; i < dp.length; i++) {
//             dp[i] = new ArrayList<>();
//         }

//         dp[1].add(1);
//         dp[2].add(2);
//         for (int i = 3; i < n; i++) {
//             dp[i].add(i);
//             for (int j = 0; j < dp[i - 2].size(); j++) {
//                 dp[i].add(dp[i - 2].get(j));
//             }
//         }

//         if (n % 2 == 1) answer[n / 2][n / 2] = n * n;

//         int num = 0;
//         int end = n - 1;

//         for (int i = 0; i < dp[end].size(); i++) {
//             int len = dp[end].get(i);
//             for (int j = 0; j < len; j++) {
//                 num++;
//                 answer[i][i + j] = num;
//             }
//             for (int j = 0; j < len; j++) {
//                 num++;
//                 answer[i + j][end - i] = num;
//             }
//             for (int j = 0; j < len; j++) {
//                 num++;
//                 answer[end - i][end - (i + j)] = num;
//             }
//             for (int j = 0; j < len; j++) {
//                 num++;
//                 answer[end - (i + j)][i] = num;
//             }
//         }

//         return answer;
//     }
// }