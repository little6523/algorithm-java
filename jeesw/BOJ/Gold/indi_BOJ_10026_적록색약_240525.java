import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] x_dir = {0, 0, -1, 1};
    static int[] y_dir = {-1, 1, 0, 0};
    static char[][] graph = new char[101][101];
    static boolean[][] visited1 = new boolean[101][101];
    static boolean[][] visited2 = new boolean[101][101];
    static int cnt1 = 0;
    static int cnt2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) bfs1(j, i);
                if (!visited2[i][j]) bfs2(j, i);
            }
        }

        bw.write(cnt1 + " " + cnt2);
        bw.flush();
        bw.close();
    }

    static void bfs1(int a, int b) {
        visited1[b][a] = true;
        Queue<Pair> q = new LinkedList<>();
        cnt1++;
        q.offer(new Pair(a, b));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int new_x = x + x_dir[i];
                int new_y = y + y_dir[i];
                if (new_x >= 0 && new_x < N && new_y >= 0 && new_y < N) {
                    if (!visited1[new_y][new_x]) {
                        if (graph[new_y][new_x] == graph[y][x]) {
                            q.offer(new Pair(new_x, new_y));
                            visited1[new_y][new_x] = true;
                        }
                    }
                }
            }
        }
    }

    static void bfs2(int a, int b) {
        visited2[b][a] = true;
        Queue<Pair> q = new LinkedList<>();
        boolean isBlue = false;
        if (graph[b][a] == 'B') isBlue = true;
        cnt2++;
        q.offer(new Pair(a, b));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int new_x = x + x_dir[i];
                int new_y = y + y_dir[i];
                if (new_x >= 0 && new_x < N && new_y >= 0 && new_y < N) {
                    if (!visited2[new_y][new_x]) {
                        if (isBlue) {
                            if (graph[new_y][new_x] == 'B') {
                                q.offer(new Pair(new_x, new_y));
                                visited2[new_y][new_x] = true;
                            }
                        } else {
                            if (graph[new_y][new_x] != 'B') {
                                q.offer(new Pair(new_x, new_y));
                                visited2[new_y][new_x] = true;
                            }
                        }
                    }
                }
            }
        }
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}