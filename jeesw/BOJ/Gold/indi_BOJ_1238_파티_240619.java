import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int to, weight;

    Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static final int INF = 100000000;
    static int N, M, X;
    static ArrayList<Node>[] comeGraph = new ArrayList[100001];
    static ArrayList<Node>[] goGraph = new ArrayList[100001];
    static int[] comeMinDist = new int[100001];
    static int[] goMinDist = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            comeGraph[i] = new ArrayList<>();
            goGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            comeGraph[b].add(new Node(a, c));
            goGraph[a].add(new Node(b, c));
        }

        for (int i = 1; i <= N; i++) {
            comeMinDist[i] = INF;
            goMinDist[i] = INF;
        }

        comeDijkstra(X);
        goDijkstra(X);

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, comeMinDist[i] + goMinDist[i]);
        }

        System.out.println(result);
    }

    static void comeDijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        comeMinDist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;
            int dist = cur.weight;

            if (comeMinDist[now] < dist) continue;

            for (Node next : comeGraph[now]) {
                int cost = dist + next.weight;
                if (cost < comeMinDist[next.to]) {
                    comeMinDist[next.to] = cost;
                    pq.offer(new Node(next.to, cost));
                }
            }
        }
    }

    static void goDijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        goMinDist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;
            int dist = cur.weight;

            if (goMinDist[now] < dist) continue;

            for (Node next : goGraph[now]) {
                int cost = dist + next.weight;
                if (cost < goMinDist[next.to]) {
                    goMinDist[next.to] = cost;
                    pq.offer(new Node(next.to, cost));
                }
            }
        }
    }
}