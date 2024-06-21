import java.util.*;

class Main {
    static final int INF = 1000000000;
    static int V, E, K;
    static ArrayList<Pair>[] graph = new ArrayList[20001];
    static int[] minDist = new int[20001];

    static void dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Arrays.fill(minDist, INF); // 초기화
        minDist[start] = 0; // 시작 노드의 거리는 0
        pq.offer(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int dist = current.dist;
            int now = current.node;

            if (dist > minDist[now]) continue; // 이미 처리된 노드면 무시

            for (Pair next : graph[now]) {
                int cost = dist + next.dist;
                if (cost < minDist[next.node]) {
                    minDist[next.node] = cost;
                    pq.offer(new Pair(next.node, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Pair(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (minDist[i] == INF) System.out.println("INF");
            else System.out.println(minDist[i]);
        }
    }
}

class Pair implements Comparable<Pair> {
    int node, dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pair o) {
        return this.dist - o.dist;
    }
}