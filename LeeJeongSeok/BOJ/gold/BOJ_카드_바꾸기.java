/**
 * [요구사항]
 * 가장 왼쪽부터 1번, 그다음이 2번..가장 오른쪽에 있는 카드가 N번인 카드 N개 주어졌을 때
 * N개의 카드에는 각각의 정수가 하나씩 적혀있다. i번째 카드에 적혀 있는 수를 Xi 라고 칭하자. -> 예는 배열로 가정했을 때 arr[i] 번째가 적혀있는 수 X다.
 *
 * N개의 카드 중 일부에 적혀있는 수들을 적절히 바꿔서 왼쪽에서 오른쪽으로 갈수록 일정하게 증가하거나, 감소하거나, 모든 수들을 같게하려고 한다.
 * 이때 바꾸는 회수를 최소화해서 3가지 중 하나의 조건을 만족해야하는 문제이다.
 *
 * [풀이 및 상태 전이도]
 *
 * 입출력 예시로 먼저 생각을 해보자
 *
 * 시간 제한이 1.5초이기 때문에 입출력이 빠른 자료구조를 선택해야한다.
 * 일단 내 개인적인 생각으로는 HashMap이 가장 빠르다.
 *
 * 굳이 일정하게 증가하는 값이나, 감소하는 값을 구할 필요가 없잖아?
 * 해시 맵의 사이즈를 체크한다.
 * 만약의 사이즈가 N의 절반보다 크다면 일정하게 감소하거나, 증가시키면 된다. 그래서 예는 N - 해시맵의 사이즈
 * 만약 사이즈가 N의 절반보다 안된다면 같은수로 덮어야한다.
 *
 * 이 풀이는 아닌거같다..;;
 *
 * 일정한 간격을 구하자
 * 일단 가장 쉽게 일정한 간격을 구할 수 있는 방법은 모든 숫자를 하나의 숫자로 통일하는 법인데, 이 방법은 비효율적이다.
 *
 * 그럼 두 수를 골라서 차이를 계산해야하는데...하..이건 2중 for문 들어가야한다.
 *
 */
import java.io.*;
import java.util.*;

public class BOJ_25401 {

	static int N;
	static int[] arr;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 두 수를 골라서 차이를 계산하자
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				// 두 수 골랐을 때 일정하게 변하는 값을 계산해야한다.
				// 실제 두 수의 차이와 거리차이를 계산해서 나누면?
				// arr[j] - arr[i] / (j - i)
				// int diff = arr[j] - arr[i] / (j - i);

				// 그리고 차이는 정수로만 이루어진다.
				// 아아 잠만 애초에 나눌때 나머지를 보면 되겠네
				// 정수가 아니면 넘겨
				if ((arr[j] - arr[i]) % (j - i) != 0) {
					continue;
				}

				int diff = (arr[j] - arr[i]) / (j - i);

				// 계산한 차이를 가지고 원본 배열과 비교하자
				// 차이값을 기준으로 새로운 리스트의 시작점을 만들자.?
				// 현재 위치에서 리스트의 시작점 값을 만들기 위해서는 일단 차이나는 만큼의 수와 현재 내 거리의 수를 곱하고, 해당 원소에 있던 값을 지운다.
				int value = arr[i] - (i - 1) * diff;

				int count = 0;
				for (int k = 1; k <= N; k++) {
					if (arr[k] != value) {
						count++;
					}

					value += diff;
				}

				answer = Math.min(answer, count);
			}
		}

		System.out.println(answer);
	}
}
