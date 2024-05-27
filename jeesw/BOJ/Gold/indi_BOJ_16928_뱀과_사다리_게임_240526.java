import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[100];
    static int[] teleport = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            teleport[start - 1] = end;
        }

        System.out.println(bfs(1));
    }

    static int bfs(int startV) {
        int roll = 0;
        int qSize;
        Queue<Integer> q = new LinkedList<>();
        visited[startV - 1] = true;
        q.offer(startV);

        while (!q.isEmpty()) {
            qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int cur = q.poll();

                for (int j = 1; j <= 6; j++) {
                    if (cur + j >= 100)    return (roll + 1);
                    if (teleport[cur + j - 1] != 0 && !visited[teleport[cur + j - 1] - 1]) {
                        visited[cur + j - 1] = true;
                        q.offer(teleport[cur + j - 1]);
                    }
                    if (teleport[cur + j - 1] == 0 && !visited[cur + j - 1]) {
                        visited[cur + j - 1] = true;
                        q.offer(cur + j);
                    }
                }
            }
            roll++;
        }

        return 0;
    }
}