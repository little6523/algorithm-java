import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static ArrayList<Pair>[] graph = new ArrayList[100000];
    static boolean[] visited = new boolean[100000];
    static int max_val = 0;
    static int root = 0;

    static void dfs(int v, int len) {
        int cnt = 0;
        for (Pair p : graph[v]) {
            if (visited[p.first])
                cnt++;
        }
        if (cnt == graph[v].size()) {
            if (max_val < len) {
                max_val = len;
                root = v;
            }
            return;
        }

        visited[v] = true;
        for (Pair p : graph[v]) {
            int x = p.first;
            if (!visited[x]) {
                dfs(x, len + p.second);
            }
        }
        visited[v] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            graph[idx - 1] = new ArrayList<>();
            while (true) {
                int tmp1 = Integer.parseInt(st.nextToken());
                if (tmp1 == -1)
                    break;
                int tmp2 = Integer.parseInt(st.nextToken());
                graph[idx - 1].add(new Pair(tmp1 - 1, tmp2));
            }
        }

        dfs(0, 0);
        Arrays.fill(visited, false);
        dfs(root, 0);

        System.out.println(max_val);
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}