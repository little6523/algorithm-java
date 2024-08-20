import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        int[] x = new int[501];
        int[] sub = new int[500];
        Map<Integer, Integer> visited = new HashMap<>();

        int result = 1000000;

        N = scanner.nextInt();
        x[0] = scanner.nextInt();

        for (int i = 1; i < N; i++) {
            x[i] = scanner.nextInt();
            sub[i - 1] = x[i] - x[i - 1];
        }

        for (int i = 0; i < N - 1; i++) {
            int sum = 0;
            for (int j = 0; j < N - 1 - i; j++) {
                sum += sub[i + j];
                if (sum % (j + 1) == 0) {
                    int key = sum / (j + 1);
                    visited.put(key, visited.getOrDefault(key, 0) + 1);
                }

                int tmp = sum / (j + 1);
                int cnt = 0;
                for (int k = 0; k < N; k++) {
                    if (x[k] != x[i] + (k - i) * tmp) {
                        cnt++;
                    }
                }
                result = Math.min(result, cnt);
            }
        }

        System.out.println(result);

        scanner.close();
    }
}