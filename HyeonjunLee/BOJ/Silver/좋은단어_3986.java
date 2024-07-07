package Bakjoon; // https://www.acmicpc.net/problem/3986

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 좋은단어_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        String ab;
        char ch;
        for (int i = 0; i < n; i++) {
            ab = br.readLine();

            // 짝이 모두 맞아야 하므로 전체 길이가 홀수일 수는 없다.
            if (ab.length() % 2 == 1) {
                continue;
            }

            stack.push(ab.charAt(0));
            for (int j = 1; j < ab.length(); j++) {
                ch = ab.charAt(j);
                
                // 현재 스택에 남아있는(짝 못찾은 애) 글자와 다음 글자가 같으면 짝을 맞춘다.
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                    continue;
                }
                stack.push(ch);
            }

            // 만약 짝을 찾는 연산을 다 했는데도 짝을 못찾은애가 남아있으면 개수 카운트 X
            if (!stack.isEmpty()) {
                stack.clear();
                continue;
            }

            // 짝을 다찾았다면 개수 카운트 +1
            answer++;
        }
        System.out.println(answer);
    }
}