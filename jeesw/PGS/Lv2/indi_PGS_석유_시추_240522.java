// import java.util.*;

// class Solution {
//     static int[] dx = {0, 0, -1, 1};
//     static int[] dy = {-1, 1, 0, 0};
//     static int[][] graph = new int[500][500];
//     static Stack<Integer> v = new Stack<>();
//     static int[] arr = new int[500];
//     static int[] tmp = new int[500];

//     public static void dfs(int x, int y, int n, int m) {
//         graph[y][x] = 0;
//         for (int i = 0; i < 4; i++) {
//             int new_x = x + dx[i];
//             int new_y = y + dy[i];
//             if (new_x < 0 || new_y < 0 || new_x >= m || new_y >= n) continue;
//             if (graph[new_y][new_x] == 1) {
//                 v.push(new_x);
//                 dfs(new_x, new_y, n, m);
//             }
//         }
//     }

//     public static int solution(int[][] land) {
//         int answer = 0;
//         int N = land.length;
//         int M = land[0].length;

//         Arrays.fill(arr, 0);

//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < M; j++) {
//                 graph[i][j] = land[i][j];
//             }
//         }

//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < M; j++) {
//                 if (graph[i][j] == 1) {
//                     v.push(j);
//                     dfs(j, i, N, M);
//                     int sum = v.size();
//                     int idx;
//                     Arrays.fill(tmp, 0);
//                     while (!v.isEmpty()) {
//                         idx = v.pop();
//                         tmp[idx]++;
//                     }
//                     for (int k = 0; k < M; k++) {
//                         if (tmp[k] != 0) {
//                             arr[k] += sum;
//                         }
//                     }
//                 }
//             }
//         }

//         for (int i = 0; i < M; i++)
//             answer = Math.max(answer, arr[i]);

//         return answer;
//     }
// }



import java.util.*;
class Solution {
    private boolean[][] visited;
    private int[] dy = new int[]{1,-1,0,0};
    private int[] dx = new int[]{0,0,1,-1};
    private int[] fuel;
    private int answer = 0;
    public void bfs(int y,int x,int[][] land){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{y,x});
        boolean[] visitedY = new boolean[land[0].length];
        visited[y][x]=true;
        visitedY[x]=true;
        int maxY = land.length;
        int maxX = land[0].length;
        int total = 1;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int i = 0; i < 4; i++){
                int ty = cur[0]+dy[i];
                int tx = cur[1]+dx[i];

                //OOM
                if(0 > ty || ty >= maxY || 0 > tx || tx >= maxX){
                    continue;
                }

                //땅이거나 이미 탐색했한 경우
                if(land[ty][tx]==0 || visited[ty][tx]){
                    continue;
                }

                visited[ty][tx]=true;
                if(!visitedY[tx]){
                    visitedY[tx]=true;
                }
                que.offer(new int[]{ty,tx});
                total += 1;
            }
        }
        for(int i = 0,iEnd=land[0].length; i < iEnd; i++){
            if(visitedY[i]){
                fuel[i]+=total;
                if(answer < fuel[i]){
                    answer = fuel[i];
                }
            }
        }
    }
    public int solution(int[][] land) {
        visited = new boolean[land.length][land[0].length];
        fuel = new int [land[0].length];

        for(int i = 0,iEnd=land.length,jEnd=land[0].length; i < iEnd; i++){
            for(int j = 0; j < jEnd; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    bfs(i,j,land);
                }
            }
        }
        return answer;
    }
}