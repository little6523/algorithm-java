package Bakjoon; // https://www.acmicpc.net/problem/3190

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int answer = 0; // 정답
        int temp = 1;   // 각 괄호의 값을 검사할 변수
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);

            // 현재 괄호의 값이 '('이면 temp * 2
            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
            }

            // 현재 괄호의 값이 '['이면 temp * 3
            else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
            }

            // 현재 괄호의 값이 ')'이고,
            else if (ch == ')') {

                // Stack의 값이 비어있거나 짝이 맞지 않으면 정답은 0
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }

                // 이전의 괄호 값이 '('라면 짝이 맞고, 괄호 안의 값이 더 이상 없기 때문에 temp에 곱해줄 필요가 없다
                // 따라서 중간 정산 수행
                else if (str.charAt(i - 1) == '(') {
                    answer += temp;
                }

                // 괄호가 닫힐 때마다 /2 수행 => 다음 열린 괄호가 나올 때를 대비
                temp /= 2;
                stack.pop();
            }

            // 현재 괄호의 값이 ')'이고,
            else if (ch == ']') {

                // Stack의 값이 비어있거나 짝이 맞지 않으면 정답은 0
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }

                // 이전의 괄호 값이 '['라면 짝이 맞고, 괄호 안의 값이 더 이상 없기 때문에 temp에 곱해줄 필요가 없다
                // 따라서 중간 정산 수행
                else if (str.charAt(i - 1) == '[') {
                    answer += temp;
                }

                // 괄호가 닫힐 때마다 /3 수행 => 다음 열린 괄호가 나올 때를 대비
                temp /= 3;
                stack.pop();
            }
        }

        // 만약 스택이 깔끔하게 비어있으면 정답 출력
        if (stack.isEmpty()) {
            System.out.println(answer);
        } else {
            // 스택에 무언가가 남아있으면 0 출력
            System.out.println(0);
        }
    }
}
