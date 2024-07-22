import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] graph = new int[300][300];
    static int[][] tmp = new int[300][300];
    static boolean[][] visited = new boolean[300][300];
    static int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int time = 0;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && graph[i][j] != 0) {
                        check(i, j);
                        cnt++;
                    }
                }
            }
            if (cnt == 0) {
                System.out.println(0);
                break;
            } else if (cnt >= 2) {
                System.out.println(time);
                break;
            }

            time++;
            meltIce();
            visited = new boolean[300][300]; // reset visited array
        }
    }

    static void check(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dir[i][0];
                int nc = cc + dir[i][1];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (graph[nr][nc] != 0 && !visited[nr][nc]) {
                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }

    static void meltIce() {
        tmp = new int[300][300]; // reset tmp array

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) continue;
                int waterCnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (graph[nx][ny] == 0) {
                        waterCnt++;
                    }
                }
                int val = graph[i][j] - waterCnt;
                if (val > 0) tmp[i][j] = val;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = tmp[i][j];
            }
        }
    }
}