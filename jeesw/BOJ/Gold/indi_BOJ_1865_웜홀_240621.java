import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 1000000000;
    static int N, M, W;
    static ArrayList<ArrayList<Pair>> graph;
    static boolean cycle;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < TC; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            cycle = false;
            dist = new int[N + 1];
            Arrays.fill(dist, INF);

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                graph.get(S).add(new Pair(E, T));
                graph.get(E).add(new Pair(S, T));
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                graph.get(S).add(new Pair(E, -T));
            }

            bellmanFord(1);
        }
    }

    static void bellmanFord(int start) {
        dist[start] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (Pair p : graph.get(j)) {
                    int next = p.first;
                    int cost = p.second;

                    if (dist[next] > dist[j] + cost) {
                        dist[next] = dist[j] + cost;
                        if (i == N) cycle = true;
                    }
                }
            }
        }

        System.out.println(cycle ? "YES" : "NO");
    }

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}