import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        System.out.print(main.solution(n, k));
        br.close();
    }

    public int solution(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[100002];
        Arrays.fill(distance, -1);
        distance[n] = 0;
        q.offer(n);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] next = {cur+1, cur-1, cur*2};
            for(int a : next){
                if(a>=0 && a<=100000 && distance[a]==-1){
                    distance[a] = distance[cur] + 1;
                    q.offer(a);
                }
            }
        }
        return distance[k];
        /*
        Set<Integer> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{n, 0});
        set.add(n);
        int answer = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int cur = tmp[0];
            int dist = tmp[1];
            if(cur==k){
                answer = dist;
                break;
            }
            int[] next = {cur+1, cur-1, cur*2};
            for(int a : next){
                if(a>=0 && a<=100000 && set.add(a)){
                    q.offer(new int[]{a, dist+1});
                }
            }
        }
        return answer;
        */
    }
}
