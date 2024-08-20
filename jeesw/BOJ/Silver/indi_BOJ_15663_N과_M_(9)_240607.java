import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Map<Integer, Integer> cntMap = new HashMap<>();
    static int[] visited = new int[10000];
    static int[] result = new int[8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            cntMap.put(tmp - 1, cntMap.getOrDefault(tmp - 1, 0) + 1);
        }

        permutation(0, 0);
    }

    static void permutation(int lev, int i) {
        if (lev == M) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
            return;
        }

        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > visited[key]) {
                visited[key]++;
                result[i] = key + 1;
                permutation(lev + 1, i + 1);
                visited[key]--;
            }
        }
    }
}