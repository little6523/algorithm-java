import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w;
    static int h;
    static char[][] space;
    static int answer;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> fireQueue;
    static Queue<int[]> personQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            fireQueue = new LinkedList<>();
            personQueue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 열
            h = Integer.parseInt(st.nextToken()); // 행
            space = new char[h][w];

            for(int j=0; j<h; j++) {
                String row = br.readLine();
                for(int k=0; k<w; k++) {
                    space[j][k] = row.charAt(k);

                    if(space[j][k] == '*') {
                        fireQueue.offer(new int[] {j, k});
                    } else if(space[j][k] == '@') {
                        personQueue.offer(new int[] {j, k, 0});
                    }
                }
            }

            answer = 0;
            bfs();

            if(answer == 0) {
                sb.append("IMPOSSIBLE").append("\n");
            } else {
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void bfs() {
        while(!personQueue.isEmpty()) {
            int size = fireQueue.size();
            for(int i=0; i<size; i++) {
                int x = fireQueue.peek()[0];
                int y = fireQueue.peek()[1];
                fireQueue.poll();

                for(int j=0; j<4; j++) {
                    int nx = x + dx[j]; // 행
                    int ny = y + dy[j]; // 열

                    if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        continue;
                    }

                    if(space[nx][ny] == '.' || space[nx][ny] == '@') {
                        space[nx][ny] = '*';
                        fireQueue.offer(new int[] {nx, ny});
                    }
                }
            }

            size = personQueue.size();
            for(int i=0; i<size; i++) {
                int x = personQueue.peek()[0];
                int y = personQueue.peek()[1];
                int count = personQueue.peek()[2];
                personQueue.poll();

                for(int j=0; j<4; j++) {
                    int nx = x + dx[j]; // 행
                    int ny = y + dy[j]; // 열

                    if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        answer = count + 1;
                        return;
                    }

                    if(space[nx][ny] == '.') {
                        space[nx][ny] = '@';
                        personQueue.offer(new int[] {nx, ny, count+1});
                    }
                }
            }
        }
    }
}
