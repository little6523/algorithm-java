import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int cnt;
    static int[] inDegree;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            cnt = 0;
            N = Integer.parseInt(br.readLine());
            
            inDegree = new int[N + 1];
            graph = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                graph[j].add(tmp);
                inDegree[tmp]++;
            }

            topologySort();

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        for (int i = 1; i <= N; i++) {
            if (q.isEmpty()) return;

            cnt++;

            int x = q.poll();

            for (int y : graph[x]) {
                if (--inDegree[y] == 0) q.offer(y);
            }
        }
    }
}