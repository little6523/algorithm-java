package Bakjoon; // https://www.acmicpc.net/problem/1012

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_1012 {

    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // map 초기화
            map = new int[n][m];
            int x, y;
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            // 맵의 전체 좌표를 검사하면서 dfs 수행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    // 성공적으로 dfs()가 끝난 곳이면 정답 카운트 +1
                    if (dfs(i, j, n, m)) {
                        answer++;
                    }
                }
            }

            System.out.println(answer);
            answer = 0;
        }
    }

    static Boolean dfs(int x, int y, int n, int m) {

        // 맵에서 벗어나면 돌아감
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        // 배추가 없는 곳이거나 이미 방문한 곳이면
        if (map[x][y] == 0 || map[x][y] == -1) {
            return false;
        }

        // 배추가 있는 곳이면 방문 처리
        if (map[x][y] == 1) {
            map[x][y] = -1;
        }

        // 해당 위치에서 더 이상 갈 수 없으면 카운트 +1
        dfs(x - 1, y, n, m);
        dfs(x, y + 1, n, m);
        dfs(x + 1, y, n, m);
        dfs(x, y - 1, n, m);

        return true;
    }
}

