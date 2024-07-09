import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            boolean[][] board = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());

                board[x][y] = true;
            }
            bw.write(String.valueOf(bfs(M, N, board)));
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int bfs(int M, int N, boolean[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]) {
                    q.offer(new int[]{i, j});
                    cnt++;
                }
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];

                        if (nx < 0 || ny < 0 || nx >= M || ny >= N || !board[nx][ny]) continue;
                        q.offer(new int[]{nx, ny});
                        board[nx][ny] = false;
                    }
                }
            }
        }
        return cnt;
    }
}
