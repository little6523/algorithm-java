import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] v;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        v = new List[N];
        parents = new int[N + 1];

        for (int i = 0; i < N; i++) {
            v[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v[a - 1].add(b);
            v[b - 1].add(a);
        }

        bfs();
    }

    static void bfs() {
        parents[0] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int newX : v[x - 1]) {
                if (parents[newX - 1] == 0) {
                    parents[newX - 1] = x;
                    q.offer(newX);
                }
            }
        }

        for (int i = 1; i < N; i++) {
            System.out.println(parents[i]);
        }
    }
}