import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] t = new int[T + 1];
        int[] p = new int[T + 1];
        int[] dp = new int[T + 2];

        for(int i=1; i<T+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = T; i >= 0; i--) {
            if(t[i] + i > T + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(p[i] + dp[i + t[i]], dp[i + 1]);
            }
        }

        System.out.println(dp[0]);
    }
}
