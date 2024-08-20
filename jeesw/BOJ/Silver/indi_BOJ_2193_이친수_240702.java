import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        long[] a = new long[90];

        a[0] = 1;
        a[1] = 1;

        for (int i = 2; i < N; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }

        System.out.println(a[N - 1]);
        
        scanner.close();
    }
}