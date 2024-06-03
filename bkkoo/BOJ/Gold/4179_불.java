import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {
    static int r;
    static int c;
    static char[][] map;
    static int[][] fireVisited;
    static int[][] playerVisited;
    static int[] dx, dy;
    static Queue<Vector2> fireQueue;
    static Queue<Vector2> playerQueue;

    public static void main(String[] args) throws IOException {
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        r = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());

        map = new char[r][c];
        fireVisited = new int[r][c];
        playerVisited = new int[r][c];
        fireQueue = new LinkedList<Vector2>();
        playerQueue = new LinkedList<Vector2>();

        //input
        for (int i = 0; i < r; i++) {
            String line = br.readLine();

            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                fireVisited[i][j] = -1;
                playerVisited[i][j] = -1;

                if (map[i][j] == 'F') {
                    fireQueue.offer(new Vector2(i, j));
                    fireVisited[i][j] = 0;
                }
                if (map[i][j] == 'J') {
                    playerQueue.offer(new Vector2(i, j));
                    playerVisited[i][j] = 0;
                }
            }
        }

        BFSFire();
        BFSPlayer();
    }

    private static void BFSPlayer() {
        while (!playerQueue.isEmpty())
        {
            Vector2 current = playerQueue.poll();
            for (int i = 0; i < 4; i++) {
                Vector2 next = new Vector2(current.x + dx[i], current.y + dy[i]);
                if (next.x < 0 || next.x >= r || next.y < 0 || next.y >= c) {
                    System.out.println(playerVisited[current.x][current.y] + 1);
                    return;
                }

                if (playerVisited[next.x][next.y] != -1 || map[next.x][next.y] != '.') {
                    continue;
                }

                if (fireVisited[next.x][next.y] != -1 && fireVisited[next.x][next.y] <= playerVisited[current.x][current.y] + 1) {
                    continue;
                }

                playerQueue.offer(next);
                playerVisited[next.x][next.y] = playerVisited[current.x][current.y] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static void BFSFire() {
        while (!fireQueue.isEmpty()) {
            Vector2 current = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                Vector2 next = new Vector2(current.x + dx[i], current.y + dy[i]);

                if (next.x < 0 || next.x >= r || next.y < 0 || next.y >= c) {
                    continue;
                }

                if (fireVisited[next.x][next.y] != -1 || map[next.x][next.y] != '.') {
                    continue;
                }

                fireQueue.offer(next);
                fireVisited[next.x][next.y] = fireVisited[current.x][current.y] + 1;
            }
        }
        //System.out.println("Fire End");
    }
}

class Vector2 {
    int x;
    int y;

    Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}