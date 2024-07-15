import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int H;
    static int[][][] tomatoBox;
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        H = Integer.parseInt(st.nextToken());// 높이
        tomatoBox = new int[H][N][M];

        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());

                for(int k=0; k<M; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    tomatoBox[i][j][k] = tomato;

                    if(tomatoBox[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while(!queue.isEmpty()) {
            int z = queue.peek()[0];
            int y = queue.peek()[1];
            int x = queue.peek()[2];
            queue.poll();

            for(int i=0; i<6; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                int cz = z + dz[i];

                if(cx >= 0 && cy >= 0 && cz >= 0 && cx < M && cy < N && cz < H) {
                    if(tomatoBox[cz][cy][cx] == 0) {
                        queue.offer(new int[] {cz, cy, cx});
                        tomatoBox[cz][cy][cx] = tomatoBox[z][y][x] + 1;
                    }
                }
            }
        }

        int result = -2;

        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(tomatoBox[i][j][k] == 0) {
                        return -1;
                    } else {
                        result = Math.max(result, tomatoBox[i][j][k]);
                    }
                }
            }
        }

        if(result == 1) {
            return 0;
        } else {
            return result - 1;
        }
    }
}
