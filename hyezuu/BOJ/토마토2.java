import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] board = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        System.out.print(bfs(board, M, N, H));
        br.close();
    }

    private static int bfs(int[][][] board, int M, int N, int H) {
        int[] dx = {0, 1, 0, -1, 0, 0};
        int[] dy = {-1, 0, 1, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, +1};

        int unRipe = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (board[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                    } else if (board[i][j][k] == 0) {
                        unRipe++;
                    }
                }
            }
        }
        int pos = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            pos = board[cur[0]][cur[1]][cur[2]];
            for (int i = 0; i < 6; i++) {
                int nx = cur[2] + dx[i];
                int ny = cur[1] + dy[i];
                int nz = cur[0] + dz[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H) continue;
                if (board[nz][ny][nx] == 0) {
                    unRipe--;
                    q.offer(new int[]{nz, ny, nx});
                    board[nz][ny][nx] = pos + 1;
                }
            }
        }

        return unRipe > 0 ? -1 : pos-1;
    }
}
