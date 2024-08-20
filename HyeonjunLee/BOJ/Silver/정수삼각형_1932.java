package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형_1932 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 계산을 위해 0번째 줄은 삼각형의 맨 위의 수를 입력 받는다.
        dp[0][0] = num[0][0];

        // 1번째 줄 부터 부터 계산 ~
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {

                // 현재 줄에서 가장 왼쪽일 때는 바로 위의 수밖에 올 수 없다.
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + num[i][j];
                    continue;
                }

                // 현재 줄에서 1 ~ n-1번째 수까지는 올 수 있는 경로가 2개이다.
                // 두 경로중에서 더 큰 경로를 택한다.
                if (j < i) {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + num[i][j];
                    continue;
                }

                // 현재 줄에서 가장 오른쪽일 때는 바로 왼쪽 위의 수밖에 올 수 없다.
                if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + num[i][j];
                }
            }
        }

        // dp의 마지막 줄에서 가장 큰 값 출력
        System.out.println(getMax(dp[n-1]));
    }

    static int getMax(int[] num) {
        int res = 0;

        for (int i = 0; i < num.length; i++) {
            if (num[i] > res) {
                res = num[i];
            }
        }

        return res;
    }
}