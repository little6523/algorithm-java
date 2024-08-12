package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] days = new int[n + 1][2];
        int[] answer = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i][0] = Integer.parseInt(st.nextToken()); // Ti
            days[i][1] = Integer.parseInt(st.nextToken()); // Pi
        }

        for (int i = 1; i < n + 1; i++) {

            // 해당일 + 상담기간이 전체기간을 넘지 않아야함
            if (i + days[i][0] > n + 1) continue;

            if (answer[i] == 0) {
                answer[i] = days[i][1];
            }

            for (int j = i + days[i][0]; j < n + 1; j++) {
                // 해당일 + 상담기간이 전체기간을 넘지 않아야함
                if (j + days[j][0] > n + 1) continue;

                // 해당 날짜를 포함하는 경우 중에서 기존의 금액보다 크면 값 업데이트
                if (answer[j] < answer[i] + days[j][1]) {
                    answer[j] = answer[i] + days[j][1];
                }
            }
        }

        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            if (max < answer[i]) {
                max = answer[i];
            }
        }

        System.out.println(max);
    }
}