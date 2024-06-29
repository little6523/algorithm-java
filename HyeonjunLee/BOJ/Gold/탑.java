import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> idx = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(arr[arr.length - 1]);
        idx.push(arr.length - 1);
        for (int i = n - 2; i > -1; i--) {
            while (stack.peek() <= arr[i]) {
                answer[idx.peek()] = i + 1;

                stack.pop();
                idx.pop();

                if (stack.isEmpty()) break;
            }
            stack.push(arr[i]);
            idx.push(i);
        }

        for (int j : answer) {
            System.out.print(j + " ");
        }
    }
}
