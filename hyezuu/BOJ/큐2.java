import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }

        System.out.print(T.queue(strings));
    }

    public String queue(String[] strings) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int rear = -1;
        for(String str : strings) {
            StringTokenizer stk = new StringTokenizer(str);
            String tmp = stk.nextToken();
            switch (tmp) {
                case "push" : {
                    rear = Integer.parseInt(stk.nextToken());
                    queue.add(rear);
                    break;
                }
                case "size" : {
                    sb.append(queue.size()).append("\n");
                    break;
                }
                case "empty" : {
                    sb.append(queue.isEmpty() ? 1: 0).append("\n");
                    break;
                }
                case "front" : {
                    sb.append(queue.isEmpty() ? -1: queue.peek()).append("\n");
                    break;
                }
                case "pop" : {
                    sb.append(queue.isEmpty() ? -1: queue.poll()).append("\n");
                    break;
                }
                case "back" :{
                    sb.append(queue.isEmpty() ? -1: rear).append("\n");
                    break;
                }
            }
        }
        return sb.toString();
    }
}

