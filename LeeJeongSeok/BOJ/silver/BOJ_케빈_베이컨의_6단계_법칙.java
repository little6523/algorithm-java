/**
 *
 * 이거 인접 리스트로 만들고 dfs 탐색 돌리면 될 듯
 *
 * 뻐킹 플로이드 와샬임;;;
 */
import java.io.*;
import java.util.*;

public class BOJ_1389 {

	static int N, M;
	static int[][] arr;
	static int INF = 9999999;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					arr[i][j] = 0;
				}
				arr[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			arr[A][B] = 1;
			arr[B][A] = 1;
		}

		for(int k = 1;k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}


		int temp = INF;
		int result = 0;

		for(int i = 1; i <= N; i++) {
			int total = 0;
			for(int j = 1;j <= N; j++) {
				total += arr[i][j];
			}

			// 케빈 베이컨 제일 작은거
			if(total < temp) {
				temp = total;
				result = i;
			}
		}

		System.out.println(result);

	}

}