/**
 * [요구사항]
 * N과 K가 주어질 때
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 순서대로 K번째 사람을 제거한다.
 *
 * [풀이 및 상태 전이도]
 * q: 1 2 3 4 5 6 7
 * count: 1
 * count가 k와 동일한지 비교
 *
 *
 * q: 2 3 4 5 6 7 1
 * count: 2
 * count가 k와 동일한지 비교
 *
 * q: 3 4 5 6 7 1 2
 * count: 3
 * count가 k와 동일한지 비교
 * result: 3
 *
 * q: 4 5 6 7 1 2
 * count: 1
 * count가 k와 동일한지 비교
 * result: 3
 *
 * q: 5 6 7 1 2 4
 * count: 2
 * result: 3
 *
 * q: 6 7 1 2 4 5
 * count: 3
 * result: 3, 6
 *
 * q: 7 1 2 4 5
 * count: 1
 * result: 3, 6
 *
 * q: 1 2 4 5 7
 * count: 2
 * result: 3, 6
 *
 * q: 2 4 5 7 1
 * count: 3
 * result: 3, 6, 2
 */


import java.util.*;
import java.io.*;

public class Main {

	static int N, K, count;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		count = 1;

		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}

		sb.append("<");
		while (!queue.isEmpty()) {
			if (count == K) {
				if (queue.size() == 1) {
					sb.append(queue.remove());
				} else {
					sb.append(queue.remove()).append(", ");
					count = 1;
				}
			} else {
				queue.add(queue.remove());
				count++;
			}
		}
		sb.append(">");

		System.out.println(sb.toString());
	}

}
