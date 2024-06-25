import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<Pair>[] graph;
    static boolean[] visited;
    static int maxVal = 0;
    static int root = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[10001];
        visited = new boolean[10001];

        for (int i = 0; i <= 10000; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Pair(b, c));
            graph[b].add(new Pair(a, c));
        }

        dfs(1, 0);
        maxVal = 0;
        Arrays.fill(visited, false);
        dfs(root, 0);

        System.out.println(maxVal);
    }

    static void dfs(int v, int len) {
        int cnt = 0;
        for (Pair p : graph[v]) {
            if (visited[p.first]) cnt++;
        }
        if (cnt == graph[v].size()) {
            if (maxVal < len) {
                maxVal = len;
                root = v;
            }
            return;
        }
        visited[v] = true;
        for (Pair p : graph[v]) {
            int next = p.first;
            if (!visited[next]) {
                int dist = len + p.second;
                dfs(next, dist);
            }
        }
        visited[v] = false;
    }

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}