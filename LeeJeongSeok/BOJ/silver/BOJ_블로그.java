/**
 * [요구사항]
 *
 * [풀이 및 상태전이도]
 * N과 X의 최대값을 보면 알겠지만 다중 for 문으로 풀면 O(n^2) 걸린다.
 * 반복적으로 배열에 접근해야하는 로직이 들어가기 때문에 이를 조금 더 효과적으로 풀어야함
 *
 * 그 중에서 슬라이딩 윈도우 알고리즘이 적합할듯
 *
 *
 * 슬라이딩 윈도우 알고리즘이란?
 * 선형 공간(1차원 배열)을 2회 이상 반복적으로 탐색할 경우 O(n^2) 이상 걸리는 시간 복잡도를 부분 배열을 활용하여 O(n)으로 줄여준다.
 */
import java.io.*;
import java.util.*;

public class BOJ_21921 {

	static int N, X;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		slidingWindow();
	}

	private static void slidingWindow() {
		int max = Integer.MIN_VALUE;
		int windowSum = 0;
		int count = 0;


		for (int i = 0; i < arr.length; i++) {
			windowSum += arr[i];

			if (i >= X - 1) {
				// 현재 윈도우의 합이 max 값과 동일한 경우 count 증가
				if (windowSum == max) {
					count++;
				}
				// 새로운 max 값을 찾았을 때, count를 1로 초기화
				if (windowSum > max) {
					max = windowSum;
					count = 1;
				}

				windowSum -= arr[i - (X - 1)];
			}

		}

		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(count);
		}
	}

}