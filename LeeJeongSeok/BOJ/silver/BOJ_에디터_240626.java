import java.util.*;
import java.io.*;

/**
 * [요구사항]
 *
 * 영어 소문자만 기록할 수 있는 에디터가 존재한다.
 * 여기서 '커서'라는 것이 있다.
 *
 * 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽), 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다.
 * 즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.
 *
 * 문자열 L이 "abcd"라고 할때
 * 커서는 " a b c d " -> 이런식으로 존재할 수 있다.
 *
 * L: 커서를 한 칸 왼쪽으로 옮김
 * D: 커서를 한 칸 오른쪽으로 옮김
 * B: 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨), 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
 * P $: $라는 문자를 커서 왼쪽에 추가함
 *
 * 초기에 편집기에 입력되어 있는 문자열이 주어지고,
 * 그 이후 입력한 명령어가 차례로 주어졌을 때, 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성하시오.
 * 단, 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다.
 *
 * [풀이 및 상태 전이도]
 *
 * 스택 2개를 사용하는 것이 좋을 것 같다.
 * 커서는 맨처음 무조건 맨뒤에 시작이다.
 *
 * 초기값
 * left-stack: 앞 [a, b, c, d] 뒤
 *
 * 현재 커서는 스택에 맨 뒤에있다.
 * 여기서 L이 들어온 경우에는 맨 뒤에 있는 요소를 다른 스택으로 옮긴다.
 *
 * left-stack: 앞 [a, b, c] 뒤
 * right-stack: 앞 [d] 뒤
 *
 * 만약 D가 들어오면 반대로 right-stack에서 left-stack으로 옮겨간다.
 * B가 들어오게 되면 스택에 가장 맨 위를 날려버린다.
 *
 * P $가 들어오게 되면 맨 커서 앞쪽에 넣으면 되기때문에
 * left-stack 맨 뒤에 있는 요소를 right-stack에 옮겨놓고, left-stack에 추가하려는 요소를 넣으면 된다.
 *
 * 출력할 때에는 left-stack의 요소를 right-stack으로 옮기고 right-stack을 하나씩 출력한다. (LIFO 성격때문)
 *
 */

public class BOJ_1406 {

	static String str = "";
	static int commandCount;
	static Stack<Character> leftStack = new Stack<>();
	static Stack<Character> rightStack = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		str = br.readLine();
		commandCount = Integer.parseInt(br.readLine());

		for (int i = 0; i < str.length(); i++) {
			leftStack.push(str.charAt(i));
		}

		while (commandCount-- > 0) {
			String commandLine = br.readLine();
			char command = commandLine.charAt(0);

			switch (command) {
				case 'L':
					if (!leftStack.isEmpty()) {
						rightStack.push(leftStack.pop());
					}
					break;
				case 'D':
					if (!rightStack.isEmpty()) {
						leftStack.push(rightStack.pop());
					}
					break;
				case 'B':
					if (!leftStack.isEmpty()) {
						leftStack.pop();
					}
					break;
				case 'P':
					char word = commandLine.charAt(2);
					leftStack.push(word);
					break;
				default:
					break;
			}
		}

		while (!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}

		while (!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}

		System.out.println(sb.toString());
	}

}