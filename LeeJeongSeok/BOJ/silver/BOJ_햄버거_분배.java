/**
 * [요구사항]
 * 기다란 벤치 모양의 식탁에서 사람들과 햄버거가 주어진 간격별로 놓여있을 때, 사람들은 자신의 위치에서 거리가 K 이하인 햄버거를 먹을 수 있다.
 * H P H P H P H H P P H P
 *
 * 범위내에서 가장 왼쪽에 가까운 버거를 먹어야 최대한으로 먹을 수 있다.
 * 역시 버거울땐 버거다.
 */

import java.io.*;
import java.util.*;

public class BOJ_19941 {

	static int N, K, count;
	static char[] table;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		table = new char[N];
		table = br.readLine().toCharArray();

		for (int i = 0; i < N; i++) {
			if (table[i] == 'P') {
				for (int j = i - K; j <= i + K; j++) {
					if (j < 0 || j >= N) {
						continue;
					}

					// 가장 왼쪽에 있는 햄버거를 발견하면 먹방 찍고, 바로 탈출해야함
					if (table[j] == 'H') {
						count++;
						table[j] = 'X';
						break;
					}
				}
			}
		}

		System.out.println(count);
	}

}