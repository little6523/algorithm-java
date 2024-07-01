/**
 * [요구사항]
 * 1부터 n까지의 수를 늘어놓을 때 하나의 수열을 만들 수 있다.
 * 이때 스택 넣는 순서는 오름차순을 지키려고 한다.
 *
 * 임의의 순열이 입력으로 주어졌을 때, 스택을 이용해 만들 수 있는지를 판별
 * 만들 수 있다면 push연산은 +로, pop 연산은 -로 표현
 *
 * [풀이 및 상태 전이도]
 *
 * 일단 입력으로 주어지는건 N과 만들어야하는 수열의 정보이다.
 * 우선 1부터 넣어야하는데 이를 저장할 start 변수를 하나 만들자
 * 입력으로 들어오는 수를 input으로 두자
 *
 * 가장 먼저 2가지 경우를 판별해야한다.
 * 1. start 변수가 input보다 작은 경우
 * 	1-1. start 변수가 input과 같아질때까지 push , start == input이 된다면 바로 pop
 * 2. start 변수가 input보다 큰 경우
 * 	2-1. 이런 경우는 이미 input이 스택 안에 있는 경우이다. 스택에 가장 위에 있는 요소과 input값을 비교한다.
 * 	2-2. 다른 경우 "NO" 를 출력하고 바로 종료
 * 	2-3. 아닌 경우는 스택에서 pop
 *
 * 자, 이제 어떻게 작성하는지가 중요한 것 같다.
 * 1번 과정과 2번 과정에 공통적으로 pop를 하는 과정이 들어간다. 그렇다면 얘는 분기문마다 작성하는것보다 분기문이 끝나면 작성해주는 것이 좋을 것 같다.
 *
 * 시간이 조금 지나고나서 재풀이 필요
 */

import java.util.*;
import java.io.*;

public class Main {

	static int N, start, input;
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		start = 0; // 0으로 초기화 시켜줘야만 두번째 케이스 통과

		while (N-- > 0) {
			input = Integer.parseInt(br.readLine());

			if (start < input) {
				for (int i = start + 1; i <= input; i++) { // 1부터 시작하기 위함도 있지만, start 변수가 input 변수에 대입된 후 그 다음값을 넣어야 하기 때문에 1증가
					stack.push(i);
					sb.append("+").append("\n");
				}
				start = input;
			} else if (stack.peek() != input) {
				System.out.println("NO");
				return;
			}

			stack.pop();
			sb.append("-").append("\n");
		}

		System.out.println(sb.toString());
	}

}