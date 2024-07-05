/**
 * [요구사항]
 * 모든 글자가 A와 B로 이루어져 있을 때, 좋은 단어의 개수를 출력해야한다.
 * 좋은 단어란? A는 A끼리 B는 B끼리 아치형으로 쌍을 맺어준다.
 * 쌍으로 맺어줄 때, 서로 선이 교차하지 않는다면 그 단어는 좋은 단어이다.
 *
 * 직접 손으로 그려보면 무슨 말인지 알것이다.
 *
 * [풀이 및 상태 전이도]
 * 이 문제는 스택 2개를 활용해서 푸는 것이 좋다.
 * 해당 변수를 leftStack, rightStack으로 선언하겠다.
 *
 * 순서는 간단하다.
 * 1. 입력으로 들어온 글자를 leftStack에 전부 다 담는다.
 * 2. leftStack에서 pop한다. 이를 top으로 저장하겠다. (leftStack의 사이즈가 1이 될때까지 4번과정까지 반복)
 * 3. leftStack의 그 다음 원소가 top과 일치하면 그 다음원소도 pop한 다음 2번으로 돌아간다.
 * 4. leftStack의 그 다음 원소가 top과 일치하지 않는다면
 * 	4-1. rightStack이 비어있는지 체크한다.
 * 		4-1-1. 비어있지 않다면 top과 rightStack의 원소와 비교 후 일치한다면 rightStack의 원소를 pop한다.
 * 		4-1-2. top과 rightStack의 원소와 비교 후 일치하지 않는다면 rightStack에 top을 push한다.
 * 	4-2. right이 비어있다면
 * 		4-2-1. top을 rightStack에 push한다.
 * 5. leftStack에 마지막 원소가 남아있고, rightStack이 비어있다면 좋은 단어가 아님
 * 6. rightStack이 비어있지 않은 상태에서 leftStack에 마지막 값이 rightStack의 상단과 동일하면 rightStack의 상단 값을 뺀다.
 * 7. 마지막으로 rightStack이 비어있다면 카운트를 늘린다.
 *
 *
 * 여기서 leftStack의 사이즈를 1로 남겨준 이유는
 * 3번 과정에서 peek 했을떄 원소가 없을 수 있기 때문이다.
 */

import java.io.*;
import java.util.*;

public class Main {

	static int N, count;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			String word = br.readLine();
			Stack<Character> leftStack = new Stack<>();
			Stack<Character> rightStack = new Stack<>();

			for (int i = 0; i < word.length(); i++) {
				leftStack.push(word.charAt(i));
			}

			while (leftStack.size() > 1) {
				Character top = leftStack.pop();

				if (top == leftStack.peek()) {
					leftStack.pop();
				} else {
					if (!rightStack.isEmpty()) {
						if (top == rightStack.peek()) {
							rightStack.pop();
						} else {
							rightStack.push(top);
						}
					} else {
						rightStack.push(top);
					}
				}
			}

			// 종료조건을 잘 정해보자
			// 왼쪽 스택에 원소가 1개가 남아있고, 오른쪽 스택이 비어있다면 좋은 단어가 아님
			if (!leftStack.isEmpty() == rightStack.isEmpty()) {
				continue;
			}

			// 오른쪽 스택이 비어있지 않은 상태에서 왼쪽 스택에 마지막 값이 오른쪽 스택의 상단과 동일하면 오른쪽 스택의 상단 값을 뺀다.
			if (!rightStack.isEmpty()) {
				if (leftStack.pop() == rightStack.peek()) {
					rightStack.pop();
				}
			}

			// 위 두 과정을 거치고난 후 둘 다 비어있다면 좋은 단어임
			if (leftStack.isEmpty() == rightStack.isEmpty()) {
				count++;
			}
		}

		System.out.println(count);
	}

}