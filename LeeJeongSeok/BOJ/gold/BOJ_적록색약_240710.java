/**
 * [요구사항]
 * 주어진 입력이 주어졌을 때, 적록색약이 아닌 사람이 본 색의 구역수와 적록색약인 사람이 본 색의 구역수를 구하자
 *
 * [풀이 및 상태 전이도]
 * 적록색약이 아닌 사람은 각 색별로 bfs 탐색을 해주면 된다
 * 하지만 적록색약인 사람은 빨강과 초록이 같아 보이기 때문에 이를 하나의 값으로 치환한다음 bfs 탐색을 돌리면 된다.
 *
 * 그렇게 되면 적록색약이 아닌 사람은 3가지 색깔에 탐색을 진행할 것이고
 * 적록색약인 사람은 2가지 색깔에 탐색을 진행할 것이다.
 *
 * 적록색약인 사람을 위해 R, G가 들어오면 이를 T로 치환해서 계산한다.
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

	static int N, normalCount, unNormalCount;
	static int[] dx;
	static int[] dy;
	static String[] normalColor;
	static String[] unNormalColor;
	static String[][] normalMap;
	static String[][] unNormalMap;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dx = new int[]{1, 0, -1, 0}; // 3시방향부터 도는거임
		dy = new int[]{0, 1, 0, -1};
		normalColor = new String[]{"R", "G", "B"};
		unNormalColor = new String[]{"T", "B"};
		normalMap = new String[N][N];
		unNormalMap = new String[N][N];
		visited = new boolean[N][N];


		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < split.length; j++) {
				normalMap[i][j] = split[j];
				unNormalMap[i][j] = split[j];

				if (split[j].equals("R") || split[j].equals("G")) {
					unNormalMap[i][j] = "T";
				}
			}
		}

		// 적록색약이 아닌 사람부터 시작
		for (int i = 0; i < normalColor.length; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (normalMap[j][k].equals(normalColor[i]) && !visited[j][k]) {
						normalCount++;
						bfs(normalMap, normalColor[i], j, k);
					}
				}
			}
		}

		sb.append(normalCount).append(" ");
		visited = new boolean[N][N];

		// 적록색약인 사람 시작
		for (int i = 0; i < unNormalColor.length; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (unNormalMap[j][k].equals(unNormalColor[i]) && !visited[j][k]) {
						unNormalCount++;
						bfs(unNormalMap, unNormalColor[i], j, k);
					}
				}
			}
		}

		sb.append(unNormalCount).append(" ");
		System.out.println(sb.toString());

	}

	private static void bfs(String[][] map, String color, int x, int y) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(x, y));
		visited[x][y] = true;


		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (visited[nx][ny] || !Objects.equals(map[nx][ny], color)) {
					continue;
				}

				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}

}