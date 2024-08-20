package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class 케빈베이컨의6단계법칙_1389 {

    public static Queue<int[]> queue = new LinkedList<>();
    public static int n, m;
    public static int[][] conn, steps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        conn = new int[n + 1][n + 1];
        steps = new int[n + 1][n + 1];

        // 관계 정보를 입력받으면서 connection(관계), steps(단계) 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            conn[a][b] = 1; conn[b][a] = 1;
            steps[a][b] = 1; steps[b][a] = 1;
        }

        System.out.println(bfs());
    }

    public static int bfs() {

        int min = Integer.MAX_VALUE, answer = n;
        for (int i = 1; i < n + 1; i++) {
            initQueue(queue, i);
            boolean[] visited = new boolean[n + 1];
            visited[i] = true;

            while (!queue.isEmpty()) {
                int[] pair = queue.poll();
                int friend = pair[0];
                int step = pair[1];

                if (visited[friend]) continue;
                visited[friend] = true;

                if (step < steps[i][friend] || steps[i][friend] == 0) {
                    steps[i][friend] = step;
                }

                for (int j = 1; j < n + 1; j++) {
                    if (conn[friend][j] == 1 && !visited[j]) {
                        queue.offer(new int[]{j, step + 1});
                    }
                }
            }

            // 현재 조사 중인 사람의 베이컨 계산
            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                if (steps[i][j] > 0) {
                    sum += steps[i][j];
                }
            }

            // 어차피 오름차순으로 조사하기 때문에 같은 경우가 나오면 무조건 작은 숫자가 들어가있다.
            // 그러므로 베이컨의 수가 같은 경우는 인덱스 크기를 비교할 필요 x
            if (sum < min) {
                min = sum;
                answer = i;
            }
        }
        return answer;
    }

    // 현재 관계를 조사 중인 사람과 연결되어 있는 다른 사람을 큐에 넣기
    public static void initQueue(Queue<int[]> queue, int index) {
        for (int i = 1; i < n + 1; i++) {
            if (conn[index][i] == 1) {
                queue.offer(new int[]{i, 1});
            }
        }
    }
}