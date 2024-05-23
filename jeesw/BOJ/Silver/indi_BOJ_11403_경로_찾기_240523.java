import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//
public class Main {
    static ArrayList<Integer>[] G;
    static boolean[] visited;
    static PriorityQueue<Integer> box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        G = new ArrayList[N];
        visited = new boolean[N];
        box = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    G[i].add(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[j] = false;
            }
            dfs(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if (!box.isEmpty() && j == box.peek()) {
                    sb.append(1).append(" ");
                    box.poll();
                } else {
                    sb.append(0).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }

    public static void dfs(int x) {
        for (int v : G[x]) {
            if (!visited[v]) {
                visited[v] = true;
                box.offer(v);
                dfs(v);
            }
        }
    }
}