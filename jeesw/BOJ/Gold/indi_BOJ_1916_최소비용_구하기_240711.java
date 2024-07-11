import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 0x3f3f3f3f;
    static int N, M;
    static ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Pair(v, cost));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int cur = current.first;
            int cost = -current.second;

            if (dist[cur] < cost) continue;

            for (Pair next : graph.get(cur)) {
                int nextNode = next.first;
                int nextCost = next.second;

                if (dist[nextNode] > cost + nextCost) {
                    dist[nextNode] = cost + nextCost;
                    pq.offer(new Pair(nextNode, -dist[nextNode]));
                }
            }
        }

        System.out.println(dist[end]);
    }

    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.second, other.second);
        }
    }
}