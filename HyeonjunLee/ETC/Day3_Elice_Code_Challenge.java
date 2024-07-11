package Elice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Day3_Elice_Code_Challenge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int answer = 0;
        char ch;

        for (int i = str.length() - 1; i > -1; i--) {
            ch = str.charAt(i);

            // 압축된 문자열인데 숫자만 있는 경우에는 길이 출력
            if (!str.contains("(") && !str.contains(")")) {
                answer = str.length();
                break;
            }

            // 압축된 문자열에 괄호가 포함되어 있는 경우 다음과 같이 처리
            // 현재 문자가 숫자일 때만 검사
            if (isNumber(ch)) {

                // 현재 숫자 다음에 '('일 경우, 저장되어 있는 값에 현재 숫자를 곱한다.
                if (str.charAt(i + 1) == '(') {
                    answer *= ch - '0';
                }

                // 현재 숫자 다음에 숫자나 ')'일 경우, 단순하게 문자열의 길이가 1 늘어난다.
                else {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }

    // 숫자인지 괄호인지 검사하는 메소드
    static boolean isNumber(char ch) {
        if (ch != '(' && ch != ')') {
            return true;
        }
        return false;
    }
}