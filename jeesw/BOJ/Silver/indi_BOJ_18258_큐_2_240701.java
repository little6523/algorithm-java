import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");

            switch (cmd[0]) {
                case "push":
                    dq.addLast(Integer.parseInt(cmd[1]));
                    break;
                case "pop":
                    bw.write(dq.isEmpty() ? "-1\n" : dq.pollFirst() + "\n");
                    break;
                case "front":
                    bw.write(dq.isEmpty() ? "-1\n" : dq.peekFirst() + "\n");
                    break;
                case "back":
                    bw.write(dq.isEmpty() ? "-1\n" : dq.peekLast() + "\n");
                    break;
                case "empty":
                    bw.write((dq.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}