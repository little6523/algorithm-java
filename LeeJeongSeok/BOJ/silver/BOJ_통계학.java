/**
 * [요구사항]
 *
 * N개의 수가 주어질때, 이때 N은 홀수개
 * 산술평균, 중앙값, 최빈값, 범위 값을 구하자
 *
 * 산술평균은 말 그대로 평균값
 * 중앙값은 오름차순으로 정렬한 후 중앙이 되는 값 찾기 (전체 길이에서 나누기 2)
 * 최빈값은 기징 믾이 나타난 값을 찾는다. 만약 여러 개 인 경우 두번째로 작은 값을 찾는다.
 *  - 최빈값이 제일 헷갈릴 수 있는데, 입출력 에시1번 처럼 모두 하나씩인 경우는 오름차순으로 정렬한 값에서 1번째 인덱스 위치한 값을 출력한다.
 * 범위는 최대값과 최소값의 차이를 구한다.
 * -2 1 2 3 8
 */

import java.io.*;
import java.util.*;

public class BOJ_2108 {

	static int N;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		average();
		center();
		frequency();
		range();

		System.out.println(sb);
	}

	private static void average() {
		sb.append(Math.round((float) Arrays.stream(arr).sum() / N)).append("\n");
	}

	private static void center() {
		sb.append(arr[arr.length / 2]).append("\n");
	}

	private static void frequency() {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		int max = Integer.MIN_VALUE;
		int count = 0;

		for (Integer value : map.values()) {
			max = Math.max(max, value);
		}

		// 빈도값이 최빈값과 동일한 경우 카운트 증가
		for (Integer value : map.values()) {
			if (value == max) {
				count++;
			}
		}

		if (count >= 2) {
			// 최빈값들 중 두번째로 작은 값 (-2, 1, 2, 3, 8), (-3, -2, -2, -1, -1)
			ArrayList<Integer> list = new ArrayList<>();

			for (Integer key : map.keySet()) {
				if (map.get(key) == max) {
					list.add(key);
				}
			}

			Collections.sort(list);
			sb.append(list.get(1)).append("\n");
		} else {
			for (Integer key : map.keySet()) {
				if (map.get(key) == max) {
					sb.append(key).append("\n");
				}
			}
		}
	}

	private static void range() {
		int range = 0;
		for (int i = arr[0]; i < arr[arr.length - 1]; i++) {
			range++;
		}

		sb.append(range).append("\n");
	}

}