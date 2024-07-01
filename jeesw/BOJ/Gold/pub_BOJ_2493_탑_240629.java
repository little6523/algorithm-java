import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Stack<Pair> stk = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            while (!stk.empty() && tmp > stk.peek().second) {
                stk.pop();
            }
            if (stk.empty()) {
                bw.write("0 ");
            } else {
                bw.write(stk.peek().first + " ");
            }
            stk.push(new Pair(i + 1, tmp));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}