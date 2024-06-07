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
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        System.out.print(T.print(T.solution(n, m, board)));
    }

    public int[] solution(int n, int m, int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int max = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || visited[i][j]) continue;
                num++;
                q.offer(new int[]{i,j}); // 시작점만 넣나
                visited[i][j] = true;
                int area = 0;
                while (!q.isEmpty()) {
                    area++;
                    int[] tmp = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = tmp[0] + dx[k];
                        int ny = tmp[1] + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visited[nx][ny] || board[nx][ny] == 0) continue;
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
                max = Math.max(max, area);
            }
        }
        return new int[]{num, max};
    }
    public String print(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i).append("\n");
        }
        return sb.toString().trim();
    }
}
