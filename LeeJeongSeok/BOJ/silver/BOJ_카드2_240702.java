/**
 * [요구사항]
 * N장에 카드가 주어질 때 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
 * 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다.
 * 우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 *
 * [풀이 및 상태 전이도]
 * 큐를 사용해서 풀면 된다.
 *
 * N = 4
 * queue: [1, 2, 3, 4]
 *
 * 버리기: 1
 * queue: [2, 3, 4]
 * 가장 맨위 뺴고, 가장 맨끝에 옮기기
 * queue: [3, 4, 2]
 *
 * 버리기: 3
 * queue: [4, 2]
 * 가장 맨위 뺴고, 가장 맨끝에 옮기기
 * queue: [2, 4]
 *
 * 버리기: 2
 * queue: [4]
 * 큐의 사이즈가 1이기 때문에 마지막 남은 카드는 4
 */
import java.util.*;
import java.io.*;

public class BOJ_2164 {

	static int N;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}

		while (queue.size() != 1) {

			// 1. 가장 맨 위 버리기
			queue.poll();

			// 2. 가장 맨 위 요소를 가장 맨 밑으로 옮기기
			queue.add(queue.poll());
		}

		System.out.println(queue.peek());
	}

}
