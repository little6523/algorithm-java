import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        int result = 0;
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x != 0) {
                stack.push(x);
            } else {
                stack.pop();
            }
        }
        
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }
        
        System.out.println(result);
    }
}
