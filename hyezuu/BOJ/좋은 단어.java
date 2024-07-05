import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        System.out.print(solution(words));
        br.close();
    }

    private static int solution(String[] words) {
        int cnt = 0;
        for (String word : words) {
            Stack<Character> stack = new Stack<>();
            for (char c : word.toCharArray()) {
                if (stack.isEmpty() || c != stack.peek()) {
                    stack.push(c);
                } else stack.pop();
            }
            if (stack.isEmpty()) cnt++;
        }
        return cnt;
    }
}
