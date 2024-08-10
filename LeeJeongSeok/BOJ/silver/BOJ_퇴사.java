/**
 * [요구사항]
 * N + 1 일째 되는 날 퇴사하기 위해 남은 N일 동안 최대한 많은 상담을 하려고한다.
 * 상담을 원료하는데 걸리는 시간 T[i]와 상담을 했을 때 받을 수 있는 P[i]로 구성되어 있을 때
 *
 * 얻을 수 있는 최대 수익을 구하자
 *
 * [풀이 및 상태 전이도]
 *
 * 일단 dp 배열을 어떻게 구상할까..?
 * dp 배열의 크기는 N + 1 만들자
 *
 *
 * 그리고 날짜를 넘는 경우가 존재함
 * 일단 날짜가 넘어가면 일을 할 수 없고, 돈도 못받음
 *
 * 날짜 안넘는경우
 * 지금까지 번돈과, 벌돈을 합칙
 *
 * 하,,모르겠댱ㅎㅎㅎㅎㅎ
 */
import java.io.*;
import java.util.*;

public class BOJ_14501 {

	static int N;
	static int[] T, P, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		T = new int[N];
		P = new int[N];
		dp = new int[N + 1];


		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			// 날짜가 초과되지 않으면서 해당 날짜에 번 돈을 계산
			if (i + T[i] <= N) {
				dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
			}

			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}

		System.out.println(dp[N]);
	}

}