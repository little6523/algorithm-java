package Bakjoon; // https://www.acmicpc.net/problem/1010

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 분자, 분모
        long numerator, denominator;

        StringTokenizer st;
        for (int i = 0; i < T; i ++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            numerator = 1;
            denominator = 1;

            // 계산을 빠르게 하기 위해 n변환 => ex) 7C5 => 7C2
            if (n > m / 2) {
                n = m - n;
            }

            // 분자 계산
            for (int j = m; j > m - n; j--) {
                numerator *= j;
            }

            // 분모 계산
            for (int j = n; j > 0; j--) {
                denominator *= j;
            }

            System.out.println(numerator / denominator);
        }
    }
}