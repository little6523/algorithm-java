/**
 * [요구사항]
 * N개의 수로 이루어진 수열과 N-1개의 연산자가 주어졌을 때
 * 수와 수 사이에 연산자를 하나씩 넣어 수식을 만든다. 이때 주어진 수의 순서는 바꿀 수 없다.
 *
 * 완성된 식은 연산자 우선 순위를 무시하고 계산한 뒤에 계산했을 때
 * 최소값과 최대값을 구하자
 *
 * [풀이 및 상태 전이도]
 *
 * N과 수열, 연산자를 저장할 변수 선언
 *
 * 연산자는 덧셈, 뺼셈, 곱셈, 나눗셈 순으로 주어진다.
 * 즉 4개의 배열이 있을때 0번지는 덧셈, 1번지는 뺄셈, 2번지는 곱셈, 3번지는 나눗셈이다.
 * 연산자 배열의 n번째 요소의 숫자가 들어있는데 그 숫자는 해당 연산자를 몇번 사용할 수 있는지를 나타낸다.
 *
 *
 * 1. 먼저 연산식을 만들어야 한다.
 * 연산식을 만들기전에 규칙을 만들자
 * 0번은 덧셈
 * 1번은 뺄셈
 * 2번은 곱셉
 * 3번은 나눗셈
 *
 * 해당 부분은 완전탐색으로 구현한다.
 *
 * 깊이가 N-1개가 되었다면 실제 연산식을 가지고 계산한다.
 *
 *
 * 2. 계산
 */
import java.io.*;
import java.util.*;

public class BOJ_14888 {

	static int N;
	static int[] arr, operator, temp;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		operator = new int[4];
		temp = new int[N - 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);


		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if (depth == N - 1) {
			// 계산하는 로직
			calculate();
		} else {
			for (int i = 0; i < operator.length; i++) {
				if (operator[i] != 0) {
					operator[i]--;
					temp[depth] = i;
					dfs(depth + 1);
					operator[i]++;
					temp[depth] = 0;
				}
			}
		}
	}

	private static void calculate() {
		int sum = arr[0];

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 0) {
				sum += arr[i + 1];
			} else if (temp[i] == 1) {
				sum -= arr[i + 1];
			} else if (temp[i] == 2) {
				sum *= arr[i + 1];
			} else {
				sum /= arr[i + 1];
			}
		}

		min = Math.min(min, sum);
		max = Math.max(max, sum);
	}

}