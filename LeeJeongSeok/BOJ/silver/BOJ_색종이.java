/**
 * [요구사항]
 * 가로, 세로 각각 100인 정사각형 모양 흰 도화지 주어졌을 때
 *
 * 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형의 검은색 색종이를 평행하게 붙힐 때
 *
 * [풀이 및 상태 전이도]
 *
 * 도화지는
 * 가로가 100
 * 세로가 100 총 넓이는 10,000
 *
 * 색종이가
 * 가로 10
 * 세로 10 총 넓이 100
 *
 *
 * 한칸씩 색칠하는 방법으로 접근
 *
 * 색종이의 갯수: N
 *
 * 색종이의 왼쪽 변과, 도화지의 왼쪽 변 사이의 거리: X (가로축)
 * 색종이의 아래쪽 변과, 도화지의 아래쪽 변 사이의 거리를: Y (세로축)
 *
 * 그러면 첫번째 색종이의 시작점은
 *
 * 도화지[3][7] 여기서부터 각각 10씩 증가해야함 그래서 결과는 도화지[13][17]
 * 해당 구간을 칠한다.
 *
 * 마찬가지로 두번째 색종이도
 *
 * 도화지[15][7] 여기서부터 각각 10씩 증가해야함 그래서 결과는 도화지[25][17]
 *
 * 마지막 세번째 색종이도
 *
 * 도화지[5][2] 여기서부터 각각 10씩 증가해야함 그래서 결과는 도화지[15][12] 만큼 칠해야함
 */

import java.io.*;
import java.util.*;

public class BOJ_2563 {

	static int N, count;
	static int[][] dohawji = new int[100][100];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (dohawji[j][k] == 1) {
						continue;
					}

					dohawji[j][k] = 1;
					count++;
				}
			}
		}

		System.out.println(count);
	}

}