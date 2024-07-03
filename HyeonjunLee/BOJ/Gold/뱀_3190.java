package Bakjoon; // https://www.acmicpc.net/problem/3190

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class 뱀_3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵 초기화
        int mapSize = Integer.parseInt(br.readLine());
        int[][] map = new int[mapSize][mapSize];

        // 사과 위치 초기화
        int appleNumber = Integer.parseInt(br.readLine());
        int positionX, positionY;

        StringTokenizer st;
        for (int i = 0; i < appleNumber; i++) {
            st = new StringTokenizer(br.readLine());
            positionX = Integer.parseInt(st.nextToken());
            positionY = Integer.parseInt(st.nextToken());
            map[positionX - 1][positionY - 1] = 1;
        }

        // 뱀의 방향 변환 정보 초기화
        int whenTurns = Integer.parseInt(br.readLine());
        List<Integer> whenTurn = new ArrayList<>();
        List<String> whatDirection = new ArrayList<>();
        for (int i = 0; i < whenTurns; i++) {
            st = new StringTokenizer(br.readLine());
            whenTurn.add(Integer.parseInt(st.nextToken()));
            whatDirection.add(st.nextToken());
        }

        // 뱀 정보 초기화
        Snake snake = new Snake(0, 0, 0);

        // 현재 시간
        int time = 0;

        // 뱀 이동
        boolean isContinue = true;
        while (isContinue) {

            // 방향을 바꿀 시간이 되면 변환
            if (!whenTurn.isEmpty() && whenTurn.get(0) == time) {
                if (whatDirection.get(0).equals("L")) {
                    snake.turnLeft();
                } else {
                    snake.turnRight();
                }
                whenTurn.remove(0);
                whatDirection.remove(0);
            }

            // 뱀 이동
            isContinue = snake.move(map);
            time += 1;
        }

        System.out.println(time);
    }
}

class Snake {

    // (x, y) 정의, 순서는 {동:0, 남:1, 서:2, 북:3}
    final static int[] xDirection = {0, 1, 0, -1};
    final static int[] yDirection = {1, 0, -1, 0};

    int x;
    int y;
    Queue<Integer> xBody = new LinkedList<>();
    Queue<Integer> yBody = new LinkedList<>();
    int direction;

    public Snake(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        xBody.add(0);
        yBody.add(0);
    }

    public boolean move(int[][] map) {
        x += xDirection[direction];
        y += yDirection[direction];

        if (isStop(map)) {
            return false;
        }

        // 이동한 위치에 사과가 있으면 몸통 늘림
        if (map[x][y] == 1) {
            xBody.offer(x);
            yBody.offer(y);
            map[x][y] = -1;
            return true;
        }

        // 뱀이 없는 곳이면 뱀 몸통 해당 칸에 추가
        if (map[x][y] == 0) {
            xBody.offer(x);
            yBody.offer(y);
            map[x][y] = -1;

            int xTail = xBody.poll();
            int yTail = yBody.poll();
            map[xTail][yTail] = 0;

            return true;
        }

        return true;
    }

    public void turnLeft() {
        direction -= 1;
        if (direction == -1) {
            direction = 3;
        }
    }

    public void turnRight() {
        direction += 1;
        if (direction == 4) {
            direction = 0;
        }
    }

    public boolean isStop(int[][] map) {
        // 벽에 부딪혔을 때
        if (x < 0 || x >= map.length || y < 0 || y >= map.length) {
            return true;
        }

        // 자기 몸에 부딪혔을 때
        if (map[x][y] == -1) {
            return true;
        }

        return false;
    }
}