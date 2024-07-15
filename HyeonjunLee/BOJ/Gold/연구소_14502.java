package Bakjoon;

import java.util.*;
import java.io.*;
import java.util.Queue;

class 연구소_14502 {

    static Queue<Position_2> queue = new LinkedList<>();
    static int[] xDirection = {-1, 0, 1, 0};
    static int[] yDirection = {0, 1, 0, -1};
    static int[][] map;
    static public int n, m;
    static int[][] wall = {{0, 0}, {0, 1}, {0, 2}};
    static List<Position_2> virus = new ArrayList<>();
    static int safe = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 연구실(맵) 정보 초기화
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 바이러스 정보 초기화
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (map[a][b] == 2) {
                    virus.add(new Position_2(a, b));
                }
            }
        }

        // 3개의 벽을 세우는 모든 케이스 검사
        for (int i = 0; i < n * m; i++) {
            for (int j = 0; j < n * m; j++) {
                for (int k = 0; k < n * m; k++) {

                    // bfs 수행
                    bfs();

                    // bfs 수행 후 queue 비우기
                    queue.clear();

                    // 각 벽의 좌표 변경
                    wall[2][1]++;

                    if (wall[2][1] == m) {
                        wall[2][1] = 0;
                        wall[2][0]++;
                    }

                    if (wall[2][0] == n) {
                        wall[2][0] = 0;
                        break;
                    }
                }
                wall[1][1]++;

                if (wall[1][1] == m) {
                    wall[1][1] = 0;
                    wall[1][0]++;
                }

                if (wall[1][0] == n) {
                    wall[1][0] = 0;
                    break;
                }
            }

            wall[0][1]++;

            if (wall[0][1] == m) {
                wall[0][1] = 0;
                wall[0][0]++;
            }
        }

        // 최대 안전 영역 출력
        System.out.println(safe);
    }

    static void bfs() {

        // 0이외의 곳에는 벽 세우기 X
        if (map[wall[0][0]][wall[0][1]] != 0 ||
                map[wall[1][0]][wall[1][1]] != 0 ||
                map[wall[2][0]][wall[2][1]] != 0) {
            return;
        }

        // 벽 2개이상 겹치기 X
        if ((wall[0][0] == wall[1][0] && wall[0][1] == wall[1][1]) ||
                (wall[1][0] == wall[2][0] && wall[1][1] == wall[2][1]) ||
                (wall[2][0] == wall[0][0] && wall[2][1] == wall[0][1])) {
            return;
        }

        // 1번째 벽이 2번째 벽보다 앞서 있기 X (줄이 다를 때)
        // 2번째 벽이 3번째 벽보다 앞서 있기 X (줄이 다를 때)
        if ((wall[0][0] > wall[1][0]) || (wall[1][0] > wall[2][0])) {
            return;
        }

        // 1번째 벽이 2번째 벽보다 앞서 있기 X (줄이 같을 때)
        // 2번째 벽이 3번째 벽보다 앞서 있기 X (줄이 같을 때)
        if ((wall[0][0] == wall[1][0]) && (wall[0][1] > wall[1][1]) ||
                (wall[1][0] == wall[2][0]) && (wall[1][1] > wall[2][1])) {
            return;
        }

        // 바이러스 생성
        for (int i = 0; i < virus.size(); i++) {
            queue.offer(virus.get(i));
        }

        // 모든 케이스를 검사해야 하므로 연구실 복사본 사용
        int[][] newMap = new int[n][m];
        copy(newMap);

        // 벽 세우기
        newMap[wall[0][0]][wall[0][1]] = 1;
        newMap[wall[1][0]][wall[1][1]] = 1;
        newMap[wall[2][0]][wall[2][1]] = 1;

        int x, y, nx, ny;
        while (!queue.isEmpty()) {
            Position_2 position = queue.poll();
            x = position.x;
            y = position.y;

            for (int i = 0; i < 4; i++) {
                nx = x + xDirection[i];
                ny = y + yDirection[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (newMap[nx][ny] == 1 || newMap[nx][ny] == 2) {
                    continue;
                }

                newMap[nx][ny] = 2;
                queue.add(new Position_2(nx, ny));
            }
        }

        // 바이러스를 모두 퍼뜨린 후, 연구실 안전 영역 검사
        check(newMap);
    }

    // 연구실의 안전 영역을 검사하는 메소드
    static void check(int[][] map) {
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    temp++;
                }
            }
        }
        if (safe < temp) {
            safe = temp;
        }
    }

    // 연구실을 복사하는 메소드
    static void copy(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = map[i][j];
            }
        }
    }
}

class Position_2 {

    int x;
    int y;

    public Position_2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}