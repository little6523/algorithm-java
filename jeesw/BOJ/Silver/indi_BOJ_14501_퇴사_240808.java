import java.util.*;

public class Main {
    static int N;
    static int[] dp = new int[16];
    static List<Integer> v0 = new ArrayList<>();
    static List<Integer> v1 = new ArrayList<>();
    static List<Integer> v2 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();

        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int t = scanner.nextInt();
            int p = scanner.nextInt();
            int tmp = 0;
            dp[i] = dp[i - 1];
            v0.add(i);
            v1.add(i + t - 1);
            v2.add(p);
            for (int j = 0; j < v0.size(); j++) {
                if (i == v1.get(j)) {
                    tmp = Math.max(tmp, dp[v0.get(j) - 1] + v2.get(j));
                }
            }
            dp[i] = Math.max(dp[i], tmp);
        }

        System.out.println(dp[N]);

        scanner.close();
    }
}