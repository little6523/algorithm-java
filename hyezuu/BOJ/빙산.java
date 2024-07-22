import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(bfs(map, N, M) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int[][] map, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] zero = new int[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int cnt = 0;
        int cnt2 = 0;

        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        q.add(new int[]{i, j});
                        cnt++;
                        if (cnt >= 2) {
                            return cnt2;
                        }
                        visited[i][j] = true;
                        while (!q.isEmpty()) {
                            int[] tmp = q.poll();
                            int x = tmp[0];
                            int y = tmp[1];
                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];

                                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                                    continue;
                                }
                                if (map[nx][ny] > 0 && !visited[nx][ny]) {
                                    q.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                                if (map[nx][ny] <= 0) {
                                    zero[x][y]++;
                                }
                            }
                        }
                    }
                }
            }
            cnt2++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (zero[i][j] > 0) {
                        map[i][j] -= zero[i][j];
                        zero[i][j] = 0;
                    }
                }
            }
            if (cnt == 0) {
                return 0;
            }
            visited = new boolean[n][m];
            cnt = 0;
        }
    }
}
