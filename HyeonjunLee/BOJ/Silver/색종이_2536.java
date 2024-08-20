package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_2536 {

    public static void main(String[] args) throws IOException {

        int[][] map = new int[100][100];
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 색종이를 아날로그형태가 아닌 디지털형태로 생각하면 겹치는부분을 표현하기가 쉽습니다.
            // 2차원좌표로 생각해서 색종이가 있는 곳을 1, 없는 곳을 0이라고 표현해주면 됩니다.
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1) {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}