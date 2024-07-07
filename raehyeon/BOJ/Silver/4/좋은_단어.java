/*
<풀이>
단어의 첫 글자를 스택에 저장한다.
두 번째 글자부터 조건에 맞게 처리한다.
만약 스택이 비어있지 않으며 스택 최상단 문자와 동일하다면 pop()을 한다.
그렇지 않다면 push()를 한다.
최종적으로 스택이 비어있다면 좋은 단어가 된다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int goodWord = 0;

        for(int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();

            String word = br.readLine();
            char first = word.charAt(0);
            stack.push(first);

            for(int j = 1; j < word.length(); j++) {
                char c = word.charAt(j);

                if(!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if(stack.isEmpty()) {
                goodWord++;
            }
        }

        System.out.println(goodWord);
    }
}
