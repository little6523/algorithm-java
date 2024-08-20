import java.util.*;
import java.io.*;

public class Main {
    static int M, N, H;
    static int[][][] graph = new int[100][100][100];
    static Queue<int[]> q = new LinkedList<>();
    static int[] dir_x = {0, 0, 0, 0, -1, 1};
    static int[] dir_y = {0, 0, -1, 1, 0, 0};
    static int[] dir_z = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int res = 0;
        boolean stop = false;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if (graph[i][j][k] == 1) {
                        q.offer(new int[]{k, j, i});
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[i][j][k] == 0) {
                        res = 0;
                        stop = true;
                        break;
                    }
                    res = Math.max(res, graph[i][j][k]);
                }
                if (stop) break;
            }
            if (stop) break;
        }

        System.out.println(res - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0], y = current[1], z = current[2];

            for (int i = 0; i < 6; i++) {
                int new_x = x + dir_x[i];
                int new_y = y + dir_y[i];
                int new_z = z + dir_z[i];
                if (new_x >= 0 && new_y >= 0 && new_z >= 0 && new_x < M && new_y < N && new_z < H) {
                    if (graph[new_z][new_y][new_x] == 0) {
                        graph[new_z][new_y][new_x] = graph[z][y][x] + 1;
                        q.offer(new int[]{new_x, new_y, new_z});
                    }
                }
            }
        }
    }
}