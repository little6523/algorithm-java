import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, k;
    static int[][] cabbage;
    static boolean[][] check;
    static int count;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            cabbage = new int[m][n];
            check = new boolean[m][n];
            count = 0;

            for(int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[x][y] = 1;
            }

            for(int j=0; j<m; j++) {
                for(int r=0; r<n; r++) {
                    if(cabbage[j][r] == 1 && !check[j][r]) {
                        bfs(j, r);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void bfs(int j, int r) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{j, r});

        while(!queue.isEmpty()) {
            j = queue.peek()[0];
            r = queue.peek()[1];
            check[j][r] = true;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = j + dx[i];
                int cy = r + dy[i];

                if (cx >= 0 && cy >= 0 && cx < m && cy < n) {
                    if (!check[cx][cy] && cabbage[cx][cy] == 1) {
                        queue.add(new int[] { cx, cy });
                        check[cx][cy] = true;
                    }
                }
            }
        }
    }
}
