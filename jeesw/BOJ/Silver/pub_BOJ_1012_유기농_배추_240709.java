import java.util.*;
import java.io.*;

public class Main {
    static int[][] map = new int[50][50];
    static int T, M, N, K;
    static int[] xpos = {0, 0, -1, 1};
    static int[] ypos = {1, -1, 0, 0};

    static void dfs(int a, int b) {
        map[b][a] = 0;
        for (int i = 0; i < 4; i++) {
            int x = a + xpos[i];
            int y = b + ypos[i];
            if (x < 0 || y < 0 || x >= M || y >= N) continue;
            if (map[y][x] == 1) dfs(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int res = 0;

            for (int j = 0; j < N; j++) {
                Arrays.fill(map[j], 0);
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == 1) {
                        dfs(k, j);
                        res++;
                    }
                }
            }

            bw.write(res + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}