/**
 * [요구사항]
 * 1 ~ N번까지 주어질 때 이를 회전하는 큐에 집어 넣는다.
 * 3가지의 연산을 진행하면서 M개의 원소 위치를 뽑았을 때 2, 3번 연산이 총 몇번 이루어지는지 카운팅한다.
 *
 * [풀이 및 상태 전이도]
 * 덱으로 풀면 좋겠지만, 이 문제는 인덱스를 기준으로 원소를 찾아야하기 때문에 원소를 찾기 위해 반복문을 매번 돌려야 하는 단점이 있다.
 * 이 들의 부모 클래스 격인 LinkedList를 사용하면 indexOf 메소드와 pollFirst & pollLast, offerFirst & offerLast를 사용할 수 있다.
 *
 * 첫번째 연산은 단순하다
 * 2, 3번 연산에 해당되지 않는다면 수행하면 된다.
 *
 * 그렇다면 2, 3반은 어떻게 처리할까?
 * 주어진 입력값을 기준으로 우리가 가장 빠르게 얻을 수 있는 값은 덱안에 있는 요소의 인덱스 위치이다.
 * 그럼 해당 인덱스 값을 어떻게 찾을까? 이게 두번째로 풀어야하는 문제이다.
 *
 * 가장 쉽게 생각해보자
 * 만약 3을 찾아야한다고 했을 때 최소한의 카운트를 가지고 찾을 수 있는 방법이 뭐가 있을까?
 * 2번 연산으로 하게 되면 3번 연산보다는 상대적으로 적은 카운트를 가지고 수행할 수 있다.
 *
 * 마찬가지로 7을 찾는다고 가정했을 때 3번 연산을 사용하면 적은 카운트를 가지고 수행할 수 있다.
 * 그럼 여기서 쉽게 생각할 수 있는 방법은 덱의 전체 길이를 반으로 나눴을 때 반보다 작냐 크냐로 비교할 수 있다.
 *
 * 작은 경우 2번 연산, 큰 경우 3번 연산으로 수행하면 풀 수 있을 듯하다.
 */
import java.util.*;
import java.io.*;

public class BOJ_1021 {

	static int N, M, count;
	static int[] targetArr;
	static LinkedList<Integer> deque = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		targetArr = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			targetArr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			deque.add(i + 1);
		}

		circularQueue();

	}

	private static void circularQueue() {

		for (int i = 0; i < targetArr.length; i++) {

			// 덱에 찾으려는 원소가 어디에 위치해있는지를 찾아야한다.
			int targetIdx = deque.indexOf(targetArr[i]);
			int halfIdx;

			// 삼항 연산자를 사용해도 좋지만, 조금 더 읽기 편하기 위해 삼항 연산자를 사용하지 않음
			if (deque.size() % 2 == 0) {
				halfIdx = deque.size() / 2 - 1;
			} else {
				halfIdx = deque.size() / 2;
			}

			if (targetIdx <= halfIdx) {
				for (int j = 0; j < targetIdx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			} else {
				for (int j = 0; j < deque.size() - targetIdx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			}
			deque.pollFirst();
		}

		System.out.println(count);
	}

}