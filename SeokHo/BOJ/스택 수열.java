import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int count = 1;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            for (;count <= num;count++) {
                stack.push(count);
                list.add("+");
            }

            if (num == stack.peek()) {
                stack.pop();
                list.add("-");
            }else {
                System.out.println("NO");
                return;
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
