import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer con = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(con.nextToken());
        int n = Integer.parseInt(con.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(T.solution(n, m, board));
    }

    public int solution(int n, int m, int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int[][] distance = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(distance[i], -1);
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }
                else if(board[i][j]==0)flag = false;
            }
        }

        if(flag) return 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int max = -1;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0 && distance[nx][ny] == -1) {
                    q.offer(new int[]{nx, ny});
                    distance[nx][ny] = distance[tmp[0]][tmp[1]]+1;
                    board[nx][ny] = 1;
                    max = Math.max(max, distance[nx][ny]);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==0) return -1;
            }
        }
        return max;
    }
}
