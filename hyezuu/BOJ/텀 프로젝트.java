import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] students = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                students[j] = Integer.parseInt(st.nextToken())-1;
            }
            sb.append(bfs(students, n)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    public static int bfs(int[] students, int n) {
        int[] status = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        int cnt = 0;

        //status[i] == 0 (아직방문한적 없음)
        //status[i] == 1 (현재 팀원구성중에 있음)
        //status[i] == 2 (팀이 꾸려졌거나 팀을 꾸릴 수 없음)
        for (int i = 0; i < n; i++) {
            if (status[i] != 2) {
                q.offer(i);
                status[i] = 1;
                last = i;
            }
            while (!q.isEmpty()) {
                int next = students[last];
                //다음 친구 넣는 조건 ; 방문한적 없어야해
                if (status[next] == 0) {
                    status[next] = 1;
                    q.offer(next);
                    last = next;
                    continue;
                }
                //다음친구가 이미 팀이 꾸려진경우, 큐에 들어가있는 애들은 다 팀을 꾸리지못한다
                if (status[next] == 2) {
                    while (!q.isEmpty()) {
                        //큐에 들어가있는친구들 빼고, 방문처리
                        status[q.poll()] = 2;
                        cnt++;
                    }
                    break;
                }
                //다음친구가 이번 큐에 방문한 적있었던경우(현재 큐에 존재할 경우)
                if (status[next] == 1) {
                    status[next] = 2;
                    while (!q.isEmpty() && q.peek() != next) {
                        //맨앞에 친구가 이번 친구일때까지
                        status[q.poll()] = 2;
                        cnt++;
                    }
                    while(!q.isEmpty()) {
                        status[q.poll()] = 2;
                    }
                }
            }
        }
        return cnt;
    }
}
