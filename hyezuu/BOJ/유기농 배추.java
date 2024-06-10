import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rp = Integer.parseInt(br.readLine());
        int[] answer = new int[rp];
        for (int i = 0; i < rp; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());
            int[][] graph = new int[n][m];

            for(int j=0; j<k; j++){
                StringTokenizer stk2 = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(stk2.nextToken());
                int x = Integer.parseInt(stk2.nextToken());
                graph[x][y] = 1;
            }
            answer[i] = main.solution(n, m, graph);
        }

        for (int a : answer) {
            System.out.println(a);
        }

        br.close();
    }

    public int solution(int n, int m, int[][] graph) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] distance = new boolean[n][m];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int cnt = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 1 && !distance[i][j]) {
                    q.offer(new int[]{i, j});
                    distance[i][j] = true;
                    cnt++;
                }
                while (!q.isEmpty()){
                    int[] cur = q.poll();
                    for(int k=0; k<4; k++){
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];

                        if(nx>=0 && nx<n && ny>=0 && ny<m && graph[nx][ny] == 1 && !distance[nx][ny]){
                            q.offer(new int[]{nx,ny});
                            distance[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
