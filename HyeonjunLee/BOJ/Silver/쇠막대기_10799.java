package Bakjoon; // https://www.acmicpc.net/problem/10799

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쇠막대기_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int poll = 0, answer = 0;
        String polls = br.readLine();
        char ch1, ch2;

        for (int i = 0; i < polls.length(); i++) {

            ch1 = polls.charAt(i);

            // 현재 문자가 '(' 이면 막대기 생성
            if (ch1 == '(') {
                poll++;
                continue;
            }

            // 현재 문자가 ')' 이면 막대기 제거
            if (ch1 == ')') {
                poll--;

                ch2 = polls.charAt(i - 1);

                // 만약 ')'의 이전 문자가 '('이면 레이저 '()'
                if (ch2 == '(') {

                    // 레이저를 쏘면 현재 레이저가 관통한 막대기들의 왼쪽부분이 잘려나간다. 즉 막대기 개수만큼 더하기
                    answer += poll;
                    continue;
                }

                // 만약 ')'의 이전 문자가 ')'이면 단순 막대기 제거
                if (ch2 == ')') {

                    // 레이저가 아닌 그냥 막대기 제거를 하게 되면 이전에 레이저에 의해 잘려나간 부분을 제외한 남은 한 토막을 추가한다.
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}