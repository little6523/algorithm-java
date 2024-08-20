/**
 * 블루레이의 크기를 임의의 값인 10으로 두고 계산한다고 가정해보자
 *
 * 문제에 나와 있는대로 레슨의 순서가 바뀌면 안되는 조건이 있어서 가장 왼쪽에서부터 순서대로 더해야한다.
 * 앞에서부터 1 + 2 + 3 + 4를 더하면 임의로 설정한 블루레이의 크기인 10과 일치하기 때문에 1개, 이후 5 + 6를 더하면 10보다 크기 때문에 더 이상 더할 수 없다. 결과적으로 블루레이의 개수는 6개가 나온다.
 * 문제에 나와있는 블루레이의 갯수는 3개이다. 하지만 위 예시대로 계산하면 블루레이의 개수가 6이기 때문에 블루레이의 크기 자체를 늘려야한다.
 *
 * 그렇다면 블루레이의 크기를 어떻게 설정할까?
 * 일단 문제의 조건은 블루레이에 영상이 다 들어가야한다는 조건이 있다.
 * 만약 블루레이 하나의 크키가 1이었다면, 레슨 1만 담기고 나머지는 모두 안담긴다
 * 왜 안담기냐?
 * 레슨 2는 크기가 2이다. 이러면 문제의 조건에 어긋난다.
 *
 * 블루레이의 개수가 많아지더라도 일단, 문제의 조건에 맞는 블루레이의 크기를 산출해야한다.
 * 여기서 생각해볼 수 있는건 레슨 중 가장 큰 숫자를 뽑으면
 * 블루레이의 개수가 많아지더라도 결국 블루레이에 다 넣을 수 있다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {

	static int N, M, left, right;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			left = Math.max(left, arr[i]);
			right += arr[i];
		}

		binarySearch();

		System.out.println(left);
	}

	private static void binarySearch() {
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			int count = 1;

			for (int i = 0; i < N; i++) {
				sum += arr[i];

				if (sum > mid) {
					sum = arr[i];
					count++;
				}
			}

			if (count <= M) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
	}
}