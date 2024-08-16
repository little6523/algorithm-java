import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int[] visitor = new int[250001];

        int sum = 0;

        for (int i = 0; i < N; i++) {
            visitor[i] = scanner.nextInt();
        }

        for (int i = 0; i < X; i++) {
            sum += visitor[i];
        }

        int result = sum;
        int cnt = 1;

        for (int i = 1; i < N - X + 1; i++) {
            sum = sum - visitor[i - 1] + visitor[X + i - 1];

            if (result < sum) {
                result = sum;
                cnt = 1;
            } else if (result == sum) {
                cnt++;
            }
        }

        if (result == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(result);
            System.out.println(cnt);
        }

        scanner.close();
    }
}