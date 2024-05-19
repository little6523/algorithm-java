import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] DP = new int[1000];

        DP[0] = 1;
        DP[1] = 2;

        for (int i = 2; i < 1000; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % 10007;
        }

        System.out.println(DP[n - 1]);
    }
}