import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer con = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(con.nextToken());
        int m = Integer.parseInt(con.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp.charAt(j) - '0';
            }
        }
        System.out.print(T.solution(n, m, board));
    }

    public int solution(int n, int m, int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int[][] distance = new int[n][m];

        for(int i=0; i<n; i++){
            Arrays.fill(distance[i], -1);
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        q.offer(new int[]{0, 0});
        distance[0][0] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && distance[nx][ny]==-1 && board[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                }
            }
        }
        return distance[n-1][m-1]+1;
    }
}
