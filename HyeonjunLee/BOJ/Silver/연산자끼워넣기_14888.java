package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888 {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] ops;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ops = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        calc(n, arr[0], arr, 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void calc(int n, int num, int[] arr, int step) {

        // 연산자를 모두 소비했을 때 max, min 계산
        if (step == n) {
            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }

            return;
        }

        // 가지고 있는 모든 연산자에 대해서 백트래킹 적용
        for (int i = 0; i < 4; i++) {

            // 연산자가 남아있으면 calc 재귀 호출
            if (ops[i] > 0) {

                // 연산자 개수 감소
                ops[i]--;

                switch (i) {
                    case 0:
                        calc(n, num + arr[step], arr, step + 1);
                        break;

                    case 1:
                        calc(n, num - arr[step], arr, step + 1);
                        break;

                    case 2:
                        calc(n, num * arr[step], arr, step + 1);
                        break;

                    case 3:
                        calc(n, num / arr[step], arr, step + 1);
                }

                // 연산자 개수 증가(다음 경우를 계산하기 위해 개수 복구)
                ops[i]++;
            }
        }
    }
}