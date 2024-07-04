import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        Deque<Integer> dq = new LinkedList<>();
        int result = 0;

        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }

        for (int i = 0; i < M; i++) {
            int tmp = sc.nextInt();
            int outNum = dq.peekFirst();
            int mid = (dq.size() - 1) / 2 + 1;

            boolean isLeft = false;
            int j = 0;
            for (int num : dq) {
                if (num == tmp) {
                    isLeft = j < mid;
                    break;
                }
                j++;
            }

            while (outNum != tmp) {
                if (isLeft) {
                    int pp = dq.pollFirst();
                    dq.addLast(pp);
                } else {
                    int pp = dq.pollLast();
                    dq.addFirst(pp);
                }

                outNum = dq.peekFirst();
                result++;
            }
            dq.pollFirst();
        }

        System.out.println(result);
        
        sc.close();
    }
}