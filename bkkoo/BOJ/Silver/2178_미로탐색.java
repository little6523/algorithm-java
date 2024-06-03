import java.io.*;
import java.util.*;

class BOJ_2178 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer con = new StringTokenizer(br.readLine());

        n = Integer.parseInt(con.nextToken());
        m = Integer.parseInt(con.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Bfs(0, 0);

        System.out.println(map[n - 1][m - 1]);
    }

    static void Bfs(int x, int y) {
        Queue<Vector2> queue = new LinkedList<>();
        queue.offer(new Vector2(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Vector2 currentPoint = queue.poll();
            for(int i=0; i<4; i++) {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];


                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if (map[nextX][nextY] == 0) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                queue.offer(new Vector2(nextX, nextY));
                visited[nextX][nextY] = true;
                map[nextX][nextY] = map[currentPoint.x][currentPoint.y] + 1;
            }
        }
    }
    static class Vector2 {
        int x;
        int y;

        Vector2(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}