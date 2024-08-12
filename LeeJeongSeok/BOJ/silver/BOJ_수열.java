/**
 * [요구사항]
 * 측정한 온도가 어떤 정수의 수열로 주어지고, 합을 구하기 위한 연속적인 날짜가 주어졌을 때 온도의 합이 가장 큰 값을 찾자.
 *
 * [풀이 및 상태 전이도]
 *
 * 그냥 보이는대로 구현해봐?
 */

import java.io.*;
import java.util.*;

public class BOJ_2559 {

	static int N, K;
	static int[] arr;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < arr.length; i++) {
			int sum = 0;

			if (i == arr.length - K) {
				for (int j = i; j < arr.length; j++) {
					sum += arr[j];
				}
				max = Math.max(max, sum);
				break;
			} else {
				for (int j = i; j < i + K; j++) {
					sum += arr[j];
				}
				max = Math.max(max, sum);
			}
		}

		System.out.println(max);
	}

}