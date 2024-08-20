/*
<풀이>
입력받은 괄호 표현의 가장 첫 괄호 문자를 스택에 저장한다.
두 번째 괄호 문자부터 직전의 괄호 문자와 비교하며 레이저로 잘린 조각의 개수를 계산한다.

괄호 문자가 '('이면 스택에 push() 한다.
괄호 문자가 ')'라면 2가지 경우로 나뉘어 판단한다.

1. 직전 문자가 '('인 경우
레이저를 의미하게 되며 파이프 개수만큼 조각이 생긴다.
즉, 스택에 pop()이 진행된 이후의 스택 사이즈가 조각의 개수가 된다.
따라서 스택에 pop()을 진행 후 조각의 합을 나타내는 변수에 스택 사이즈를 더해준다.

2. 직전 문자가 ')'인 경우
파이프의 끝을 의미하게 되며 1조각만 생기게 된다.
왜냐하면 파이프의 길이는 모두 다르기 때문에 동시에 끝이 여러 개 나오는 경우는 없다.
따라서 스택에 pop()을 진행 후 조각의 합을 나타내는 변수에 1을 더해준다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String pipe = br.readLine();
        char start = pipe.charAt(0);
        stack.push(start);

        int piece = 0;

        for(int i=1; i<pipe.length(); i++) {
            char c1 = pipe.charAt(i);
            char c2 = pipe.charAt(i-1);

            if(pipe.charAt(i) == ')') {
                if(c2 == '(') {
                    stack.pop();
                    piece += stack.size();
                } else {
                    stack.pop();
                    piece += 1;
                }
            } else {
                stack.push(c1);
            }
        }

        System.out.println(piece);
        br.close();
    }
}
