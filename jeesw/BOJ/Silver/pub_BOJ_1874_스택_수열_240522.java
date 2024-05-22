import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> operations = new ArrayList<>();
        int pointer = 0;
        boolean isValid = true;
        
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            while (pointer < val) {
                stack.push(++pointer);
                operations.add("+");
            }
            if (val == stack.peek()) {
                stack.pop();
                operations.add("-");
            } else {
                System.out.println("NO");
                isValid = false;
                break;
            }
        }
        
        if (isValid) {
            for (String op : operations) {
                System.out.println(op);
            }
        }
        
        scanner.close();
    }
}