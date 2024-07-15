package Bakjoon;

import java.util.*;
import java.io.*;
import java.util.Queue;

class 불_5427 {

    static char[][] map;
    static Queue<int[]> person = new LinkedList<>();
    static Queue<int[]> fire = new LinkedList<>();
    static int[] xDirection = {-1, 0, 1, 0};
    static int[] yDirection = {0, 1, 0, -1};
    static int w, h;
    static int time = 0;
    static boolean isPossible = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            // 맵 초기화 및 상근과 불의 좌표를 큐에 넣기
            String temp;
            for (int i = 0; i < h; i++) {
                temp = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = temp.charAt(j);
                    if (temp.charAt(j) == '@') {
                        person.offer(new int[]{i, j});
                    }

                    if (temp.charAt(j) == '*') {
                        fire.offer(new int[]{i, j});
                    }
                }
            }

            while (true) {

                // bfs수행
                bfs();

                // 탈출 가능하다면 시간 출력 후, 다음 케이스를 위해 모든 정보 초기화
                if (isPossible) {
                    System.out.println(time + 1);
                    time = 0;
                    isPossible = false;
                    person.clear();
                    fire.clear();
                    break;
                }

                // 상근의 큐가 다 비었다 -> 더 이상 갈 곳이 없다
                // 큐가 다 비었는데도 탈출하지 못했으면 IMPOSSIBLE 출력
                else {
                    if (person.isEmpty()) {
                        System.out.println("IMPOSSIBLE");
                        time = 0;
                        fire.clear();
                        break;
                    }
                }

                // 매 초마다 bfs수행 후, 종료조건을 검사했을 때 종료가 안됬으면 시간 +1
                time++;
            }
        }
    }

    static void bfs() {

        // 매 초마다의 상황을 체킹해야 한다 -> 매 초마다 큐에 들어있는 것에 대해서만 bfs를 수행하기 위해
        // size변수에 미리 큐의 사이즈를 저장하여 사용한다.
        // (queue.size()로 하면, 나중에 큐에 좌표가 들어오면 다시 반복문이 돌아간다...)
        int size = fire.size();

        for (int i = 0; i < size; i++) {
            int[] newFire = fire.poll();

            for (int j = 0; j < 4; j++) {
                int nx = newFire[0] + xDirection[j];
                int ny = newFire[1] + yDirection[j];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                if (map[nx][ny] == '*' || map[nx][ny] == '#') {
                    continue;
                }

                // 불의 경우, 다음으로 갈 수 있는 칸을 미리 방문 처리
                // 상근이가 '불이 옮겨 붙을 칸'도 가면 안되니깐~
                map[nx][ny] = '*';
                fire.offer(new int[]{nx, ny});
            }
        }

        size = person.size();
        for (int i = 0; i < size; i++) {
            int[] newPerson = person.poll();

            // 상근이가 지금 있는 위치가 탈출할 수 있는 곳이면 탈출 (처음 입력한 좌표가 탈출 지점일 때를 검사하기 위함)
            if (newPerson[0] == 0 || newPerson[0] == h - 1 || newPerson[1] == 0 || newPerson[1] == w - 1) {
                isPossible = true;
                return;
            }

            for (int j = 0; j < 4; j++) {
                int nx = newPerson[0] + xDirection[j];
                int ny = newPerson[1] + yDirection[j];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                if (map[nx][ny] == '*' || map[nx][ny] == '#' || map[nx][ny] == '@') {
                    continue;
                }

                // 다음에 이동할 칸이 탈출할 수 있는 곳이면 탈출
                if (nx == 0 || nx == h - 1 || ny == 0 || ny == w - 1) {
                    isPossible = true;
                    time++;
                    return;
                }

                map[nx][ny] = '@';
                person.offer(new int[]{nx, ny});
            }
        }
    }
}