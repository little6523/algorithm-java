import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int l = Integer.parseInt(br.readLine());
            int[][] board = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int curY = Integer.parseInt(st.nextToken());
            int curX = Integer.parseInt(st.nextToken());
            Pos cur = new Pos(curX, curY);

            st = new StringTokenizer(br.readLine());

            int destY = Integer.parseInt(st.nextToken());
            int destX = Integer.parseInt(st.nextToken());
            Pos dest = new Pos(destX, destY);

            bw.write(bfs(board, cur, dest) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static int bfs(int[][] board, Pos cur, Pos dest) {
        int l = board.length;

        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};

        Queue<Pos> queue = new LinkedList<>();
        queue.offer(cur);
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            if (pos.equals(dest)) return board[pos.y][pos.x];
            for (int i = 0; i < dx.length; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                if (board[ny][nx] == 0) {
                    board[ny][nx] = board[pos.y][pos.x] + 1;
                    queue.offer(new Pos(nx, ny));
                }
            }
        }
        return board[dest.y][dest.x];
    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return x == pos.x && y == pos.y;
    }
}
