import java.io.*;
import java.util.*;

class Triple {
	private int x;
	private int y;
	private int z;

	public Triple(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
}


public class BOJ_7569 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] dx = new int[]{1, 0, -1, 0, 0, 0};
		int[] dy = new int[]{0, 1, 0, -1, 0, 0};
		int[] dz = new int[]{0, 0, 0, 0, 1, -1};

		int[][][] tomatoes = new int[H][N][M];
		int[][][] dates = new int[H][N][M];

		int empty = 0;
		int result = 0;

		LinkedList<Triple> queue = new LinkedList<>();

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					int tomato = Integer.parseInt(st.nextToken());
					tomatoes[k][i][j] = tomato;
					// -1로 초기화를 해두면 별도의 visit 배열이 필요없음
					dates[k][i][j] = -1;

					// 동시에 익은 토마토가 있는 곳이 여러곳이 있을 수 있기 때문에 큐에 집어넣는다.
					if (tomato == 1) {
						queue.offer(new Triple(i, j, k));
						// 익은 토마토는 날짜를 0으로 초기화 할 수 있다.
						// 왜냐면 이미 익었기 떄문에 날짜를 카운팅하지 않음
						dates[k][i][j] = 1;
					}
					if (tomato == -1) {
						empty++;
					}
				}
			}
		}


		while (!queue.isEmpty()) {
			Triple currentTomatoLocation = queue.poll();

			for (int i = 0; i < 6; i++) {
				int newX = currentTomatoLocation.getX() + dx[i];
				int newY = currentTomatoLocation.getY() + dy[i];
				int newZ = currentTomatoLocation.getZ() + dz[i];

				// 새로운 좌표값이 격자모양 안에 들어가있는지 확인
				if (newX < 0 || newX >= N || newY < 0 || newY >= M || newZ < 0 || newZ >= H) {
					continue;
				}

				if (tomatoes[newZ][newX][newY] == -1 || dates[newZ][newX][newY] != -1) {
					continue;
				}

				queue.offer(new Triple(newX, newY, newZ));
				dates[newZ][newX][newY] = dates[currentTomatoLocation.getZ()][currentTomatoLocation.getX()][currentTomatoLocation.getY()] + 1;


			}
		}

		int temp = 0;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (dates[k][i][j] == -1) {
						temp++;
					} else {
						if (dates[k][i][j] > result) {
							result = dates[k][i][j];
						}
					}
				}
			}
		}


		if (temp != empty) {
			System.out.println(-1);
		} else {
			System.out.println(result - 1);
		}
	}
}