import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l;
    static int nowX;
    static int nowY;
    static int targetX;
    static int targetY;
    static int[][] board;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];

            st = new StringTokenizer(br.readLine());
            nowX = Integer.parseInt(st.nextToken());
            nowY = Integer.parseInt(st.nextToken());
            board[nowX][nowY] = 1;
            queue.add(new int[]{nowX, nowY});

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            System.out.println(bfs());
        }
    }

    public static int bfs() {
        while(!queue.isEmpty()) {
            if(board[targetX][targetY] != 0) {
                queue.clear();
                break;
            }

            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for(int i=0; i<8; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(cx >= 0 && cy >= 0 && cx < l && cy < l) {
                    if(board[cx][cy] == 0) {
                        queue.offer(new int[] {cx, cy});
                        board[cx][cy] = board[x][y] + 1;
                    }
                }
            }
        }

        int result = board[targetX][targetY] - 1;
        return result;
    }
}
