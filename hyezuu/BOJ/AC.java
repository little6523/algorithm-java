import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String nums = br.readLine();
            StringTokenizer st = new StringTokenizer(nums.substring(1, nums.length() - 1), ",");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            bw.write(solution(p, arr));
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static String solution(String p, int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        boolean rev = false;

        for (int a : arr) {
            deque.addLast(a);
        }

        for (char a : p.toCharArray()) {
            if (a == 'R') {
                rev = !rev;
            } else if (deque.isEmpty()) {
                return "error";
            } else if (rev) {
                deque.pollLast();
            } else {
                deque.pollFirst();
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            sb.append(rev ? deque.pollLast() : deque.pollFirst()).append(',');
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);

        return sb.insert(0, '[').append(']').toString();
    }
}
