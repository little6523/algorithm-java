import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] p = new int[100000];

        int cur = 0;

        for (int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
            if (i < K) cur += p[i];
        }

        int result = cur;

        for (int i = 1; i < N - K + 1; i++) {
            cur = cur - p[i - 1] + p[i + K - 1];
            result = Math.max(result, cur);
        }

        System.out.println(result);

        sc.close();
    }
}