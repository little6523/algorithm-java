import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String inputs = br.readLine();

            int cur = 0;
            int cnt_d = 0;
            int cnt_r = 0;

            Deque<Integer> d = new ArrayDeque<>();

            for (char c : command.toCharArray()) {
                if (c == 'D') cnt_d++;
                else cnt_r++;
            }

            if (cnt_d > size) {
                sb.append("error\n");
            } else if (cnt_d == size) {
                sb.append("[]\n");
            } else {
                String[] nums = inputs.substring(1, inputs.length() - 1).split(",");
                for (String num : nums) {
                    if (!num.isEmpty()) {
                        d.add(Integer.parseInt(num));
                    }
                }

                for (char c : command.toCharArray()) {
                    if (c == 'D') {
                        if (cur == 0) d.pollFirst();
                        else d.pollLast();
                    } else {
                        cur = 1 - cur;
                    }
                }

                if (cnt_r % 2 == 1) {
                    Deque<Integer> reversed = new ArrayDeque<>();
                    while (!d.isEmpty()) {
                        reversed.add(d.pollLast());
                    }
                    d = reversed;
                }

                sb.append('[');
                while (!d.isEmpty()) {
                    sb.append(d.pollFirst());
                    if (!d.isEmpty()) sb.append(',');
                }
                sb.append("]\n");
            }
        }

        System.out.print(sb);
    }
}