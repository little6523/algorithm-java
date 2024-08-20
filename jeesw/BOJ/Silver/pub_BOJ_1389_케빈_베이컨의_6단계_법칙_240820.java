import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph = new ArrayList[101];
    static boolean[] visited = new boolean[101];
    static int[] level = new int[101];
    static int mini = Integer.MAX_VALUE;
    static int[] tmp = new int[101];
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            tmp[i] = bfs(i);
            mini = Math.min(mini, tmp[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (mini == tmp[i]) {
                res = i;
                break;
            }
        }

        System.out.println(res);
    }

    static int bfs(int v) {
        int cnt = 0;
        level[v] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int w = q.poll();
            for (int x : graph[w]) {
                if (!visited[x]) {
                    q.add(x);
                    visited[x] = true;
                    level[x] = level[w] + 1;
                    cnt += level[x];
                }
            }
        }

        return cnt;
    }
}