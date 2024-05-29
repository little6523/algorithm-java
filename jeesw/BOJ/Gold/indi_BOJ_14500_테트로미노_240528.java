//#include <iostream>
//
//int N, M;
//int paper[500][500];
//int sum_info[500][500][5];
//int x_dir[4] = { 0, 0, -1, 1 };
//int y_dir[4] = { -1, 1, 0, 0 };
//int rot_dir[4] = { 1, 0, 3, 2 };
//int result = 0;
//
//int main()
//{
//	std::ios::sync_with_stdio(0);
//	std::cin.tie(0);
//
//	std::cin >> N >> M;
//
//	for (int i = 0; i < N; i++) {
//		for (int j = 0; j < M; j++) {
//			std::cin >> paper[i][j];
//		}
//	}
//
//	// 정점마다 상하좌우로 2개씩 연결(합)
//	// 방향 정보: 3차 배열의 세번째 인덱스, 연결된 두 합: 값
//	// sum_info[i][j][4]에는 최대값이 들어갈 예정
//	for (int i = 0; i < N; i++) {
//		for (int j = 0; j < M; j++) {
//			for (int k = 0; k < 4; k++) {
//				int x = j + x_dir[k];
//				int y = i + y_dir[k];
//				if (x < 0 || y < 0 || x >= M || y >= N)	sum_info[i][j][k] = 0;
//				else sum_info[i][j][k] = paper[i][j] + paper[y][x];
//			}
//		}
//	}
//
//	// 최대인 부분 연결
//	for (int i = 0; i < N; i++) {
//		for (int j = 0; j < M; j++) {
//			int dir = 0;	// 1->2 방향
//			int dir2 = 0;	// 2->3 방향
//			int dir3 = 0;	// 3->4 방향
//			int x_2 = 0, y_2 = 0;	// 2번째 x와 y좌표
//			int x_3 = 0, y_3 = 0;	// 3번째 x와 y좌표
//			int max_val = 0;
//			int max_val2 = 0;
//			int t_tmp1, t_tmp2;
//
//			// 첫 번째 최대 연결
//			for (int k = 0; k < 4; k++) {
//				if (sum_info[i][j][4] < sum_info[i][j][k]) {
//					int x = j + x_dir[k];
//					int y = i + y_dir[k];
//					if (x < 0 || y < 0 || x >= M || y >= N)	continue;
//					x_2 = x;
//					y_2 = y;
//					dir = k;
//				}
//				sum_info[i][j][4] = std::max(sum_info[i][j][4], sum_info[i][j][k]);
//			}
//
//			//두 번째 최대 연결
//			for (int k = 0; k < 4; k++) {
//				if (k == rot_dir[dir])	continue;
//				int x = x_2 + x_dir[k];
//				int y = y_2 + y_dir[k];
//				if (x < 0 || y < 0 || x >= M || y >= N)	continue;
//				int sum = sum_info[i][j][4] + paper[y][x];
//				if (max_val < sum) {
//					x_3 = x;
//					y_3 = y;
//					dir2 = k;
//				}
//				max_val = std::max(max_val, sum);
//			}
//			sum_info[i][j][4] = max_val;
//
//			//세 번째 최대 연결
//			for (int k = 0; k < 4; k++) {
//				if (k == rot_dir[dir2])	continue;
//				int x = x_3 + x_dir[k];
//				int y = y_3 + y_dir[k];
//				if (x < 0 || y < 0 || x >= M || y >= N)	continue;
//				int sum = sum_info[i][j][4] + paper[y][x];
//				max_val2 = std::max(max_val2, sum);
//			}
//
//			// T블럭 고려 dir 역방향과 dir2를 제외한 두번째 좌표에서 값 두개
//			for (int k = 0; k < 4; k++) {
//				if (k == rot_dir[dir] || k == dir2)	continue;
//				int x = x_2 + x_dir[k];
//				int y = y_2 + y_dir[k];
//				if (x < 0 || y < 0 || x >= M || y >= N)	continue;
//				int sum = sum_info[i][j][4] + paper[y][x];
//				max_val2 = std::max(max_val2, sum);
//			}
//
//			sum_info[i][j][4] = max_val2;
//			result = std::max(result, max_val2);
//		}
//	}
//
//	std::cout << result << "\n";
//
//	return 0;
//}



import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result;
    static int[][] paper = new int[600][600];
    static boolean[][] visited = new boolean[600][600];
    static int[] dir_x = {0, 0, -1, 1};
    static int[] dir_y = {-1, 1, 0, 0};

    static void dfs(int x, int y, int cnt, int val) {
        if (cnt == 4)
            result = (result < val) ? val : result;
        else {
            for (int i = 0; i < 4; i++) {
                int new_x = x + dir_x[i];
                int new_y = y + dir_y[i];
                if (new_x < 0 || new_y < 0 || new_x > M || new_y > N) continue;
                if (!visited[new_y][new_x]) {
                    visited[new_y][new_x] = true;
                    dfs(new_x, new_y, cnt + 1, val + paper[new_y][new_x]);
                    visited[new_y][new_x] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // T블럭을 제외하면 한붓그리기를 하듯 dfs로 탐색 가능
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visited[i][j] = true;
                dfs(j, i, 1, paper[i][j]);
                visited[i][j] = false;
            }
        }

        // T블럭 고려
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int t = paper[i][j];    // T블럭의 가운데
                int mini = 1001;
                for (int k = 0; k < 4; k++) {
                    mini = (mini < paper[i + dir_y[k]][j + dir_x[k]]) ? mini : paper[i + dir_y[k]][j + dir_x[k]]; // 가운데 점의 상하좌우에 있는 값 중에 최소의 값을 나타낸다
                    t += paper[i + dir_y[k]][j + dir_x[k]];   // 상하좌우에 있는 값을 모두 더한다. 그러면 십자가 모양처럼 되니 테트로미노가 아니다
                }
                result = (result < t - mini) ? t - mini : result; // 상하좌우에 있는 값 중 최소 값을 제거한다. 그러면 보라색 테트로미노의 모양이 된다
            }
        }

        System.out.println(result);
    }
}