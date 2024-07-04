package Bakjoon; // https://www.acmicpc.net/problem/1021

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회전하는큐_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 큐의 크기
        int m = Integer.parseInt(st.nextToken()); // 뽑아낼 숫자의 개수

        // 숫자 찾는 로직
        // 문제에서는 첫 번째 인덱스로만 숫자를 뺀다. -> 1번 인덱스로 가기 위한 최소 회전 수를 구해야된다.

        int[] idx = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            idx[i] = Integer.parseInt(st.nextToken());
        }

        int left, right;
        int answer = 0;


        for (int i = 0; i < m; i++) {

            // 바로 빼는 경우
            if (idx[i] == 1) {
                for (int j = i; j < m; j++) {
                    idx[j] -= 1;
                    if (idx[j] < 0) {
                        idx[j] = n;
                    }
                }
                n -= 1;
                continue;
            }

            // 왼쪽으로 회전: (해당 숫자 인덱스 - 시작인덱스(1))
            left = idx[i] - 1;

            // 오른쪽으로 회전: (큐의 마지막 인덱스 - 해당 숫자 인덱스 + 1) -> 큐의 마지막으로 보내고 다시 한 번 오른쪽 회전
            right = n - idx[i] + 1;

            if (left >= right) {
                answer += right;

                // 연산 후 남은 숫자의 위치 계산
                for (int j = i; j < m; j++) {
                    idx[j] += right;
                    if (idx[j] > n) {
                        idx[j] -= n;
                    }

                    // 맨 앞의 숫자를 하나 제거하면 인덱스 하나씩 더 줄어든다.
                    idx[j] -= 1;
                }

            } else {
                answer += left;

                // 연산 후 남은 숫자의 위치 계산
                for (int j = i; j < m; j++) {
                    idx[j] -= left;
                    if (idx[j] < 1) {
                        idx[j] += n;
                    }

                    // 맨 앞의 숫자를 하나 제거하면 인덱스 하나씩 더 줄어든다.
                    idx[j] -= 1;
                }
            }

            n -= 1;
        }
        System.out.println(answer);
    }
}
