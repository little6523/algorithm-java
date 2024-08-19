package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BABBA_9625 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] ab = {1, 0};

        // 모든 a는 b로 바뀌고, b는 ba로 바뀐다.
        // 그렇다면 k번 눌렀을 때 a, b의 개수는 각각 다음과 같다.
        // a: (현재 a의 개수 - 현재 a의 개수 + 현재 b의 개수) = (현재 b의 개수)
        // b: (현재 b의 개수 + 현재 a의 개수)
        for (int i = 0; i < k; i++) {
            int a = ab[1];
            int b = ab[0] + ab[1];
            ab[0] = a; ab[1] = b;
        }
        System.out.println(ab[0] + " " + ab[1]);
    }
}