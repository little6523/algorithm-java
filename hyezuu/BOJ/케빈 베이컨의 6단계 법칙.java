import java.io.*;
import java.util.*;

class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <=N; i++) {
            graph.add(new LinkedList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        int min = Integer.MAX_VALUE;
        int answer = 0;

        for(int i = 1; i <= N; i++) {
            if(min > solution(i)){
                min = solution(i);
                answer = i;
            }
        }

        System.out.print(answer);
        br.close();
    }

    static int solution(int num) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{num, 0});

        boolean[] visited = new boolean[graph.size()];
        visited[num] = true;
        
        int chk = N-1;
        int sum = 0;

        while(!q.isEmpty() && chk > 0) {
            int[] cur = q.poll();

            for(int i : graph.get(cur[0])) {
                if(!visited[i]) {
                    visited[i] = true;
                    chk--;
                    q.offer(new int[]{i ,cur[1]+1});
                    sum+= cur[1]+1;
                }
            }
        }
        return sum;
    }
}
