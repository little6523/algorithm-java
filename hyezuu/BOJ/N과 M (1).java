import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static Stack<Integer> stack;
    static boolean[] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer cond = new StringTokenizer(br.readLine());
        N = Integer.parseInt(cond.nextToken());
        M = Integer.parseInt(cond.nextToken());

        solution(N, M);
    }

    private static void solution(int N, int M) {
        stack = new Stack<>();
        visited = new boolean[N + 1];

        recursion(1);
    }

    private static void recursion(int pos) {
        if (stack.size() == M) print(stack);

        for (int i = 1; i <= N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            stack.push(i);
            recursion(i);
            stack.pop();
            visited[i] = false;

        }
    }

    private static void print(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();

        for (int a : stack) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
        ;
    }
}
