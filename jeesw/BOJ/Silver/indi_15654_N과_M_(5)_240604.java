import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] v;
    static boolean[] visited;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new int[N];
        visited = new boolean[N];
        res = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(v);

        permutation(0);
    }

    static void permutation(int lev) {
        if (lev == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[lev] = v[i];
                permutation(lev + 1);
                visited[i] = false;
            }
        }
    }
}