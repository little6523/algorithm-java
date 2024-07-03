import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(solution(n,k));

        bw.flush();
        bw.close();
        br.close();
    }

    public static String solution(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int cnt = 1;
        for(int i=1; i<=n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            if(cnt == k) {
                sb.append(q.poll()).append(", ");
                cnt = 0;
            }
            else q.offer(q.poll());
            cnt++;
        }

        return sb.replace(sb.length()-2,sb.length()-1,">").toString();
    }
}


