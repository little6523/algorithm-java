import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        Queue<Integer> q = new LinkedList<>();
        int temp;

        for (int i = 0; i < N; i++) {
            q.offer(i + 1);
        }

        while (q.size() > 1) {
            q.poll();
            temp = q.poll();
            q.offer(temp);
        }

        System.out.println(q.peek());

        scanner.close();
    }
}