package Bakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치와 날짜를 저장하는 클래스
class Position {
    int x;
    int y;
    int z;
    int day;

    public Position(int x, int y, int z, int day) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
}

class Main {

    // 토마토 상자, bfs를 수행할 큐, (가로, 세로, 높이), 소요일
    static int[][][] tomatoes;
    static Queue<Position> queue = new LinkedList<>();
    static int m, n, h;
    static int day;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        // 토마토 상자 초기화
        tomatoes = new int[h][n][m];

        int value;
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < m; x++) {
                    value = Integer.parseInt(st.nextToken());
                    tomatoes[z][y][x] = value;
                    if (value == 1) {
                        queue.offer(new Position(x, y, z, 0));
                    }
                }
            }
        }

        // bfs 수행
        bfs();
    }

    static void bfs() {

        // 큐가 비어있지 않을 때
        while (!queue.isEmpty()) {

            // 큐에서 하나 씩 빼서 검사
            Position position = queue.poll();
            int x = position.x;
            int y = position.y;
            int z = position.z;

            // 첫 토마토가 익은지 얼마나 지났는지 저장
            day = position.day;

            // 상자 밖으로 굴러 떨어진 토마토는 줍지 않는다...
            if (x < 0 || x >= m || y < 0 || y >= n || z < 0 || z >= h) {
                continue;
            }

            // 첫 날에는 토마토를 찾아서 주위를 익혀야 되므로 day == 0은 통과시킨다.
            // 상자 칸에 -1이거나 토마토가 이미 익어있으면 건너뛴다.
            if (day > 0 && (tomatoes[z][y][x] == 1 || tomatoes[z][y][x] == -1)) {
                continue;
            }

            // 익지 않은 토마토는 익힌다.
            tomatoes[z][y][x] = 1;

            // 상, 하, 좌, 우, 위, 아래의 인접한 토마토들을 큐에 넣는다.
            queue.offer(new Position(x + 1, y, z, day + 1));
            queue.offer(new Position(x - 1, y, z, day + 1));
            queue.offer(new Position(x, y + 1, z, day + 1));
            queue.offer(new Position(x, y - 1, z, day + 1));
            queue.offer(new Position(x, y, z + 1, day + 1));
            queue.offer(new Position(x, y, z - 1, day + 1));
        }

        // 큐가 비어있으면
        if (check()) {
            
            // 정답을 출력한다.
            // 여기서 -1을 한 이유는 마지막 토마토가 빠져나올 때 day를 +1을 해주기 때문이다.
            System.out.println(day - 1);
        } else {
            
            // 익지 못한 토마토가 있다면 -1을 출력한다.
            System.out.println(-1);
        }
    }

    // 상자에 익지 않은 토마토가 있는지 검사하는 메소드
    static boolean check() {
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (tomatoes[z][y][x] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

