import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int end = 0; // 큐의 마지막 값을 저장하기 위한 변수

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String func = st.nextToken();

            switch(func) {
                case"push":
                    int num = Integer.parseInt(st.nextToken());
                    q.offer(num);
                    end = num;
                    break;

                case "pop":
                    if(q.isEmpty()) {
                        sb.append(-1).append("\n");;
                    } else {
                        sb.append(q.poll()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    if(q.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if(q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.peek()).append("\n");
                    }
                    break;

                case "back":
                    if(q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(end).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
