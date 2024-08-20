package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class 빙산_2573 {

    static int n, m;
    static int[][] map;
    static Queue<Integer> melting = new LinkedList<>(); // 해당 위치에서 녹일 얼음의 높이를 저장하는 큐
    static List<int[]> ice = new ArrayList<>(); // 얼음의 위치를 저장하는 리스트
    static Queue<int[]> temp = new LinkedList<>(); // 매번 bfs 수행 시 방문할 얼음의 위치를 저장하는 임시 큐
    static boolean[][] visited;
    static int[] xDirection = {-1, 0, 1, 0};
    static int[] yDirection = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        // 맵 초기화 및 얼음 위치를 배열에 추가
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    ice.add(new int[]{i, j});
                }
            }
        }

        // count: 한 번의 bfs()를 수행할 때마다 카운트
        // answer: 정답
        // isEnd: 얼음이 2덩어리를 체크하자마자 종료하는 조건
        int count = 0, answer = 0;
        boolean isEnd = false;

        // 얼음이 다 녹을 때까지
        while (!ice.isEmpty()) {

            // 녹일 얼음의 높이 계산
            for (int[] pos : ice) {
                melt(pos[0], pos[1]);
            }

            // 얼음을 녹임
            for (int[] pos : ice) {
                if (!melting.isEmpty()) {
                    map[pos[0]][pos[1]] -= melting.poll();
                    if (map[pos[0]][pos[1]] < 0) map[pos[0]][pos[1]] = 0;
                }
            }

            // 얼음을 녹인 후 정답 카운트 + 1
            answer++;

            // 현재 녹아서 0(물)이된 얼음 제거
            checkIce();

            // 매 bfs() 수행 시 조사할 얼음의 위치를 임시 변수에 복사
            copyIce();

            // 현재 살아있는 얼음들의 모든 위치에 대해 bfs() 수행
            for (int[] pos : ice) {

                // 이미 방문한 얼음이면 건너뜀
                if (visited[pos[0]][pos[1]]) continue;

                // bfs탐색에 성공했으면 얼음 한 덩어리 추가
                if (bfs(pos[0], pos[1])) {
                    count++;
                }

                // 아직 얼음이 2덩어리 이상 발견하지 못했고, 조사하지 않은 얼음이 있으면 건너뜀
                if (count < 2 && !temp.isEmpty()) continue;

                // 얼음 2덩어리를 발견하자마자 탐색 종료
                if (count == 2) {
                    isEnd = true;
                    break;
                }
            }

            // 종료 조건이 true이면 반복문 탈출
            if (isEnd) break;

            // 얼음을 녹이고, 탐색하는 과정이 끝났는데 아직 종료가 안되었다면
            // 다시 얼음을 녹이고, 탐색하는 과정을 수행하기 위해 변수 초기화
            count = 0;

            melting.clear();
            visited = new boolean[n][m];
        }

        if (isEnd) {
            System.out.println(answer);
        } else {
            System.out.println(0);
        }

    }

    // 얼음 사르르 녹이는 메소드
    static void melt(int x, int y) {

        int nx, ny, count = 0;

        for (int i = 0; i < 4; i++) {
            nx = x + xDirection[i];
            ny = y + yDirection[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (map[nx][ny] == 0) {
                count++;
            }
        }

        melting.offer(count);
    }

    // 하나의 덩어리를 모두 방문하는 메소드
    static boolean bfs(int x, int y) {

        // 해당 좌표가 물이면 false 반환
        if (map[x][y] == 0) return false;

        // bfs를 위한 큐를 만들고, 방문 처리
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        temp.poll();

        int nx, ny, dx, dy;
        int[] xy;
        while (!queue.isEmpty()) {

            xy = queue.poll();
            dx = xy[0];
            dy = xy[1];

            for (int i = 0; i < 4; i++) {
                nx = dx + xDirection[i];
                ny = dy + yDirection[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                temp.poll();
                queue.offer(new int[]{nx, ny});
            }
        }

        return true;
    }

    // 다 녹은 얼음 제거
    static void checkIce() {
        if (ice.isEmpty()) return;

        int x, y, i = 0;
        while (i < ice.size()) {
            x = ice.get(i)[0];
            y = ice.get(i)[1];

            if (map[x][y] == 0) {
                ice.remove(i);
                i--;
            }
            i++;
        }
    }

    // 얼음의 현재 위치를 bfs를 수행하기 위한 임시 큐에 복사
    static void copyIce() {
        temp.clear();
        for (int i = 0; i < ice.size(); i++) {
            temp.offer(ice.get(i));
        }
    }
}