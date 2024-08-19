/**
 * [요구사항]
 * K가 주어졌을 때 A, B의 개수를 맞추는 프로그램을 작성
 * A -> B
 * B -> BA
 * BA -> BAB
 * BAB -> BABBA
 *
 * 느 낌 상 DP 각...
 */

import java.io.*;
import java.util.*;

public class BOJ_9625 {

	static int K;
	static int[][] dp = new int[2][46];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		dp[0][2] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		for (int i = 3; i <= K; i++) {
			dp[0][i] = dp[0][i-2] + dp[0][i-1];
			dp[1][i] = dp[1][i-2] + dp[1][i-1];
		}
		System.out.print(dp[0][K] + " " + dp[1][K]);
	}

}
