import java.util.*;
import java.io.*;

public class Main {
    static int l;
    static int[][] graph = new int[301][301];
    static int dest_x, dest_y;
    static int[] dir_x = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dir_y = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            dest_x = Integer.parseInt(st.nextToken());
            dest_y = Integer.parseInt(st.nextToken());

            for (int i = 0; i < l; i++) {
                Arrays.fill(graph[i], -1);
            }

            bw.write(bfs(start, end) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        graph[y][x] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];

            if (cur_x == dest_x && cur_y == dest_y) return graph[cur_y][cur_x];

            for (int i = 0; i < 8; i++) {
                int new_x = cur_x + dir_x[i];
                int new_y = cur_y + dir_y[i];
                if (new_x < 0 || new_y < 0 || new_x >= l || new_y >= l || graph[new_y][new_x] > -1) continue;
                graph[new_y][new_x] = graph[cur_y][cur_x] + 1;
                q.offer(new int[]{new_x, new_y});
            }
        }
        return -1;
    }
}