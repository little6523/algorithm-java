import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = tmp.charAt(j);
            }
        }

        System.out.print(main.solution(n, grid));
        br.close();
    }

    public String solution(int n, char[][] graph) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int cnt = 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        StringBuilder sb = new StringBuilder();

        boolean flag = false;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            char cur = graph[tmp[0]][tmp[1]];

            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (graph[nx][ny] == cur) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                } else if (flag) {
                    if ((cur == 'G' && graph[nx][ny] == 'R') || (cur == 'R' && graph[nx][ny] == 'G')) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }

            }
            if (q.isEmpty()) {
                outer : for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!visited[i][j]) {
                            q.offer(new int[]{i, j});
                            visited[i][j] = true;
                            cnt++;
                            break outer;
                        }
                    }
                }
            }
            if (q.isEmpty() && !flag) {
                flag = true;
                q.offer(new int[]{0, 0});
                visited = new boolean[n][n];
                visited[0][0] = true;
                sb.append(cnt).append(" ");
                cnt = 1;
            }
        }
        return sb.append(cnt).toString();
    }
}
