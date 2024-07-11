/**
 * [요구사항]
 * 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다.
 * 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.
 *
 * 한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어 놓았다.
 * 배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.
 *
 * 한 마리의 배추흰지렁이가 있다면 인접한 모든 배추에 대해 상하좌우로 이동할 수 있다.
 * 인접하지 않다면 추가적으로 배추흰지렁이를 추가해야한다.
 *
 * 더 쉽게 정리하면 인접한 배추의 덩어리가 총 몇군데인지를 파악하면 끝난다.
 *
 *
 * [풀이 및 상태 전이도]
 * 사실, 전형적인 그래프 탐색의 문제이다.
 * 방향 배열과, 방문 배열을 가지고 탐색할 줄 알다면 다 풀 수 있다.
 *
 * 해당 풀이는 bfs로 풀었다.
 */

import java.io.*;
import java.util.*;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class Main {
	static int T, M, N, K, count;
	static int dx[];
	static int dy[];
	static int map[][];
	static boolean visited[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			dx = new int[]{1, 0, -1, 0};
			dy = new int[]{0, 1, 0, -1};
			map = new int[N][M];
			visited = new boolean[N][M];
			count = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
			}


			// 전체 탐색하면서 bfs 탐색을 할 수 있는 곳을 찾는다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						count++;
						bfs(i, j);
					}
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}

				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
}
