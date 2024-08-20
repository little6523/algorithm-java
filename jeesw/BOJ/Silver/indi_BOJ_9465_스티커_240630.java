import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp = new int[100000][2];
    static int[][] val = new int[100000][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    val[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            dp[n - 1][0] = val[n - 1][0];
            dp[n - 1][1] = val[n - 1][1];

            if (n >= 2) {
                dp[n - 2][0] = Math.max(val[n - 1][0], val[n - 2][0] + val[n - 1][1]);
                dp[n - 2][1] = Math.max(val[n - 1][1], val[n - 2][1] + val[n - 1][0]);
            }

            if (n >= 3) {
                for (int i = n - 3; i >= 1; i--) {
                    dp[i][0] = Math.max(val[i][0] + dp[i + 1][1], val[i + 1][0] + dp[i + 2][1]);
                    dp[i][1] = Math.max(val[i][1] + dp[i + 1][0], val[i + 1][1] + dp[i + 2][0]);
                }

                dp[0][0] = val[0][0] + dp[1][1];
                dp[0][1] = val[0][1] + dp[1][0];
            }

            bw.write(Math.max(dp[0][0], dp[0][1]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}