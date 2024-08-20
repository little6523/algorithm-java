import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dijkstra(N);
    }

    static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, N});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int val = current[0];
            int cur = current[1];

            visited[cur] = true;

            if (cur == K) {
                System.out.println(val);
                return;
            }

            if (cur - 1 >= 0 && !visited[cur - 1]) pq.offer(new int[]{val + 1, cur - 1});
            if (cur + 1 <= 100000 && !visited[cur + 1]) pq.offer(new int[]{val + 1, cur + 1});
            if (cur * 2 <= 100000 && !visited[cur * 2]) pq.offer(new int[]{val, cur * 2});
        }
    }
}