import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] campus = new char[601][601];
    static Queue<Pair> q = new LinkedList<>();
    static int[] dir_x = {0, 0, -1, 1};
    static int[] dir_y = {-1, 1, 0, 0};
    static int result = 0;

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int new_x = x + dir_x[i];
                int new_y = y + dir_y[i];
                if (new_x >= 0 && new_x < M && new_y >= 0 && new_y < N) {
                    if (campus[new_y][new_x] == 'O' || campus[new_y][new_x] == 'P') {
                        q.offer(new Pair(new_x, new_y));
                        if (campus[new_y][new_x] == 'P') {
                            campus[new_y][new_x] = '1';
                            result++;
                        }
                        campus[new_y][new_x] = 'X';
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    q.offer(new Pair(j, i));
                    campus[i][j] = 'X';
                }
            }
        }

        bfs();

        System.out.println(result == 0 ? "TT" : result);
    }
}