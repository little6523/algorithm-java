package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 적록색약_10026 {

    static int n;
    static char[][] map;
    static boolean[][] visited;
    static boolean redGreenBlindness = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵과 방문 여부 배열 초기화
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];

        String temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        int answer = 0;

        // 적록색약일 때 + 아닐 때 각 1번씩 수행
        for (int i = 0; i < 2; i++) {
            
            // 모든 맵의 좌표를 돌면서 dfs() 수행
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dfs(j, k, map[j][k])) {
                        answer++;
                    }
                }
            }
            
            // 정답 출력하고 초기화
            System.out.print(answer + " ");
            answer = 0;

            // 방문 여부 초기화 및 적록색약 여부 변경
            visited = new boolean[n][n];
            redGreenBlindness = true;
        }
    }

    static boolean dfs (int x, int y, char ch) {
        // 해당 좌표가 맵 밖이면 false 반환
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }

        // 해당 좌표가 이미 방문한 좌표이면 false 반환
        if (visited[x][y]) {
            return false;
        }

        // 적록색약이 아니면
        if (!redGreenBlindness) {
            
            // 현재 좌표의 문자가 영역을 검사할 문자와 다르면 false 반환
            // ex) 처음 탐색을 시작한 좌표의 문자가 'B'라면 'B'만 탐색하게 한다.
            if (map[x][y] != ch) {
                return false;
            }
        }

        // 적록색약이면
        else {

            // 영역을 검사할 문자가 R 또는 G이고 현재 좌표의 문자가 'G'이면 false 반환
            if ((ch == 'R' || ch == 'G') && map[x][y] == 'B') {
                return false;
            }

            // 영역을 검사할 문자가 B이고 현재 좌표의 문자가 'R'이나 'G'이면 false 반환
            else if ((ch == 'B') && (map[x][y] == 'R' || map[x][y] == 'G')) {
                return false;
            }
        }

        // 위의 조건들을 이겨내고 여기까지 왔다면 방문 처리
        visited[x][y] = true;

        // 다시 4방향으로 dfs() 수행
        dfs(x - 1, y, ch);
        dfs(x, y + 1, ch);
        dfs(x + 1, y, ch);
        dfs(x, y - 1, ch);

        // 무사히 끝났다면 true 반환
        return true;
    }
}