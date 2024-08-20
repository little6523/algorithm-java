/**
 * [요구사항]
 * 정수 배열을 연산하려고 한다.
 * R은 수의 순서를 뒤집고, D는 가장 맨 앞에 있는 수를 버린다.
 *
 * 수행할 함수 P와
 * 배열의 길이인 N, 그리고 N에 맞게 초기값이 주어졌을 때 최종결과를 구하자
 *
 * [풀이 및 상태 전이도]
 * 얼핏 봤을 땐, 회전하는 큐보다 쉬워보인다.
 *
 * 간단하다.
 * 덱을 사용하자
 *
 * 어? R이면 뒤집어야 하는데? 라고 생각할 수 있지만
 * R에 대한 flag값을 준 다음 true일 때는 뒤에서, false인 경우 앞에서 접근하는 형태로 풀면 된다.
 *
 * 그 외 D인 경우는 맞춰서 삭제하면 된다. 조심할 점은 덱이 비어있을 때 D가 들어오면 error를 내뱉자.
 *
 * 근데 조심해야할 건 초기값이 [1,2,3,4] 식으로 들어온다.
 *
 * 다시 고려해야할 점이
 * DDDD 하다가, 만약 원소가 없다면 error를 뱉어야한다.
 * 그래서 작업하는 도중에 출력작업을 수행하는 것 보단, 명렁어가 끝나고 나서 출력구문을 만드는 것이 훨씬 좋다.
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			LinkedList<Integer> deque = new LinkedList<>();
			boolean isReverse = false;
			boolean isError = false;
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());

			// parsing 작업부터 하자
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			// 명령어 시작
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == 'R') {
					isReverse = !isReverse;
				} else {
					if (isReverse) {
						if (deque.pollLast() == null) {
							System.out.println("error");
							isError = true;
							break;
						}
					} else {
						if (deque.pollFirst() == null) {
							System.out.println("error");
							isError = true;
							break;
						}
					}
				}
			}

			if (!isError) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if (deque.size() > 0) {
					if (isReverse) {
						sb.append(deque.pollLast());
						while (!deque.isEmpty()) {
							sb.append(",").append(deque.pollLast());
						}
					} else {
						sb.append(deque.pollFirst());
						while (!deque.isEmpty()) {
							sb.append(",").append(deque.pollFirst());
						}
					}
				}
				sb.append("]");
				System.out.println(sb.toString());
			}
		}
	}

}