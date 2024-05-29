import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph = new ArrayList[1000];
    static boolean[] visited = new boolean[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 1000; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i);
                res++;
            }
        }

        System.out.println(res);
    }

    static void dfs(int vertex) {
        if (visited[vertex]) return;
        visited[vertex] = true;
        for (int x : graph[vertex]) {
            if (!visited[x]) dfs(x);
        }
    }
}