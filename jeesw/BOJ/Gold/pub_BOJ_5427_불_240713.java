import java.util.*;
import java.io.*;

public class Main {
    static int w, h;
    static Cell[][] building = new Cell[1001][1001];
    static Queue<int[]> q = new LinkedList<>();
    static int[] dir_x = {0, 0, -1, 1};
    static int[] dir_y = {-1, 1, 0, 0};

    static class Cell {
        char first;
        int second;

        Cell(char first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            Queue<int[]> tmp = new LinkedList<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            q.clear();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = line.charAt(j);
                    building[i][j] = new Cell(c, -1);
                    if (c == '@') {
                        q.offer(new int[]{j, i});
                        building[i][j].second = 1;
                    } else if (c == '*') {
                        tmp.offer(new int[]{j, i});
                        building[i][j].second = 0;
                    }
                }
            }
            while (!tmp.isEmpty()) {
                q.offer(tmp.poll());
            }

            bw.write(bfs() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            
            if (building[cur_y][cur_x].first == '@') {
                if (cur_x == 0 || cur_y == 0 || cur_x == w - 1 || cur_y == h - 1) {
                    return String.valueOf(building[cur_y][cur_x].second);
                }
            }

            for (int i = 0; i < 4; i++) {
                int new_x = cur_x + dir_x[i];
                int new_y = cur_y + dir_y[i];
                if (new_x < 0 || new_y < 0 || new_x >= w || new_y >= h) continue;
                if (building[new_y][new_x].first == '#') continue;
                if (building[cur_y][cur_x].first == '@' && building[new_y][new_x].first != '*') {
                    if (building[new_y][new_x].second > -1) continue;
                    building[new_y][new_x].first = '@';
                    building[new_y][new_x].second = building[cur_y][cur_x].second + 1;
                    q.offer(new int[]{new_x, new_y});
                } else if (building[cur_y][cur_x].first == '*') {
                    if (building[new_y][new_x].second == 0) continue;
                    building[new_y][new_x].first = '*';
                    building[new_y][new_x].second = 0;
                    q.offer(new int[]{new_x, new_y});
                }
            }
        }
        return "IMPOSSIBLE";
    }
}