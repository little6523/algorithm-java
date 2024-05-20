import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        System.out.print("<");
        
        // 마지막 ,를 없애기 위해 원소 한 개를 남기고 순회
        while (q.size() > 1) {
            // 빼기 전 값 까지 뒤로 다시 보냄.
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            System.out.print(q.poll() + ", ");
        }

        System.out.print(q.poll() + ">");
    }
}