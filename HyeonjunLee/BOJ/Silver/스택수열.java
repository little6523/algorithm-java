import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = new ArrayList<>();
        StringBuilder ops = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        int number;
        int pushedNumber = 0;
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            number = arr.get(i);

            if (pushedNumber < number) {
                for (int j = pushedNumber + 1; j <= number; j++) {
                    stack.push(j);
                    ops.append("+\n");
                }
                pushedNumber = number;
            }

            if (stack.peek() > number) {
                System.out.println("NO");
                isPossible = false;
                break;
            }

            stack.pop();
            ops.append("-\n");
        }

        if(isPossible) {
            System.out.println(ops);
        }
    }
}
