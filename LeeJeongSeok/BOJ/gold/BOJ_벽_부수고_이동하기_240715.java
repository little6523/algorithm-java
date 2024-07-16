package cote_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [요구사항]
 * N * M 행렬이 주어질 때, 0은 이동할 수 있고 1은 이동할 수 없다.
 * 최단경로로 이동해야한다.
 * 최단경로란? 가장 적은 개수의 칸으로 지나는 경로를 의미한다.
 * 시작칸와 끝 칸도 개수의 포함된다.
 *
 * [풀이 및 상태 전이도]
 * 벽을 1개만 깰 수 있기 때문에 하나 깨면 끝이다.
 * 그러므로 벽을 만나자마자 벽을 꺨 수 있는지 없는지 여부를 판별해야한다.
 *
 * DFS 탐색으로 벽인 칸을 부수고 그 안에서 BFS 탐색을 시도하려고 했지만, 잘 생각해봐야하는 점은 0,0 에서 출발이다.
 * 뭔가 말로 표현할 수 없지만, 느낌상 비효율적이다.
 *
 * BFS 탐색을 돌면서 벽인지 아닌지를 먼저 선별한 후, 만약 벽일 때 벽을 깼는지 안깼는지 여부를 판별하면 된다.
 * 이렇게 탐색했을 때 끝지점에 도달했다면 distance를 출력하고, 그렇지 않다면 -1를 출력하면 된다.
 *
 * 여기서 중요한점은 방문 배열을 2가지 타입으로 만들어야한다.
 * 벽을 부셨던 방문 배열과 벽을 부시지 않은 방문 배열로
 * 벽을 부시지 않았다면 부시지 않은 방문배열로 bfs 탐색을 해야하고, 벽을 부셨다면 부셨던 방문 배열로 bfs탐색을 진행해야한다.
 */

class Wall {
	int x;
	int y;
	int distance;
	boolean isCrash;

	public Wall(int x, int y, int distance, boolean isCrash) {
		this.x = x;
		this.y = y;
		this.distance = distance;
		this.isCrash = isCrash;
	}
}

public class Main {

	static int N, M;
	static int[] dx;
	static int[] dy;
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dx = new int[]{1, 0, -1, 0};
		dy = new int[]{0, 1, 0, -1};
		map = new int[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < split.length; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		bfs(0, 0, 1, false);

	}

	private static void bfs(int x, int y, int distance, boolean isCrash) {
		Queue<Wall> queue = new LinkedList<>();
		queue.add(new Wall(x, y, distance, isCrash));
		visited[x][y][0] = true;

		while (!queue.isEmpty()) {
			Wall cur = queue.poll();

			if (cur.x == N - 1 && cur.y == M - 1) {
				System.out.println(cur.distance);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];


				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				int nextDistance = cur.distance + 1;

				// 벽을 부셨는지 체크하기
				if (map[nx][ny] == 0) {
					// 벽을 부시지 않았고, 아직 부시지 않은 방문 배열을 탐색하지 않은 경우
					if (!cur.isCrash && !visited[nx][ny][0]) {
						queue.add(new Wall(nx, ny, nextDistance, false));
						visited[nx][ny][0] = true;
					} else if (cur.isCrash && !visited[nx][ny][1]) { // 벽을 부셨고, 부신 방문 배열을 탐색하지 않은 경우
						queue.add(new Wall(nx, ny, nextDistance, true));
						visited[nx][ny][1] = true;
					}
				} else {
					// 벽을 부시지 않은 상태에서 벽을 만난 경우
					if (!cur.isCrash) {
						queue.add(new Wall(nx, ny, nextDistance, true));
						visited[nx][ny][1] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}

}
