import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][][] map = new int[1000][1000][2];
    static int[] xDir = {0, 0, -1, 1};
    static int[] yDir = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j][0] = line.charAt(j) - '0';
            }
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int broken = current[0];
            int x = current[1];
            int y = current[2];

            if (x == M - 1 && y == N - 1) return map[N - 1][M - 1][broken] + 1;

            for (int i = 0; i < 4; i++) {
                int newX = x + xDir[i];
                int newY = y + yDir[i];

                if (newX < 0 || newY < 0 || newX >= M || newY >= N) continue;
                if (map[newY][newX][0] == 1) {
                    if (broken == 0) {
                        map[newY][newX][1] = map[y][x][0] + 1;
                        q.offer(new int[]{1, newX, newY});
                    }
                } else if (map[newY][newX][0] == 0) {
                    if (broken == 1 && map[newY][newX][1] != 0) continue;
                    map[newY][newX][broken] = map[y][x][broken] + 1;
                    q.offer(new int[]{broken, newX, newY});
                }
            }
        }

        return -1;
    }
}