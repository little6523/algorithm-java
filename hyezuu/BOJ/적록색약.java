import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(board, N, true)+" "+bfs(board, N, false));
    }

    private static int bfs(char[][] board, int N, boolean isGeneral) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        int cnt = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    q.offer(new int[]{i, j});
                    cnt++;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            if (visited[nx][ny]) continue;
                            if (isGeneral(board[i][j], board[nx][ny], isGeneral)) {
                                q.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }

    static boolean isGeneral(char ch1, char ch2, boolean chk) {
        boolean isGeneral = ch1 == ch2;

        if(chk) return isGeneral ;
        return  isGeneral || (ch1 == 'R' && ch2 == 'G') || (ch1 == 'G' && ch2 == 'R');
    }
}
