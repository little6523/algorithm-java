/**
 * [요구사항]
 *
 * 주어진 명령에 따라서 큐를 이용해 처리하는 프로그램을 작성
 *
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 * [문제 풀이]
 * 실제로 큐 클래스를 사용하면 좋지만, 연습이 되지 않는다.
 * 배열로 풀어보는것이 어떨까?
 *
 * 사실 배열로 풀게 되면 첫번째와 마지막 인덱스 값을 갱신하는 로직만 조심하면 된다.
 */
import java.io.*;
import java.util.*;

public class Main {

	static int N, start, end;
	static final int SIZE = 2000000;
	static StringBuilder sb = new StringBuilder();
	static int[] arr = new int[SIZE];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		start = 0;
		end = 0;

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {
				case "push":
					arr[end] = Integer.parseInt(st.nextToken());
					end++;
					break;
				case "pop":
					if (arr[start] == 0) {
						sb.append(-1).append("\n");
					} else {
						sb.append(arr[start]).append("\n");
						arr[start] = 0;
						start++;
					}
					break;
				case "size":
					sb.append(end - start).append("\n");
					break;
				case "empty":
					sb.append(arr[start] == 0 ? 1 : 0).append("\n");
					break;
				case "front":
					sb.append(arr[start] == 0 ? -1 : arr[start]).append("\n");
					break;
				case "back":
					sb.append(arr[start] == 0 ? -1 : arr[end - 1]).append("\n");
					break;
			}
		}

		System.out.println(sb.toString());
	}
}
