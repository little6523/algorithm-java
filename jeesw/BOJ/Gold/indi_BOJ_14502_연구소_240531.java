import java.util.*;

public class Main {
    static int N, M;
    static int[][] room = new int[8][8]; // 연구실
    static int[][] graph = new int[8][8]; // 백트래킹하며 연구실로 초기화
    static int[] dir_x = {0, 0, -1, 1};
    static int[] dir_y = {-1, 1, 0, 0};
    static int[] positionCombination = new int[3]; // (연구소 사이즈)C3으로 위치 저장
    static boolean[] visited = new boolean[64];
    static Queue<Pair> start_q = new LinkedList<>();
    static ArrayList<Integer> zero_sum = new ArrayList<Integer>(); // 보호되는 공간 (bfs 실행 후 0이 되는 부분 합)

    public static void main(String[] args) {
        int result = 0;
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = sc.nextInt();
                if (room[i][j] == 2) start_q.offer(new Pair(j, i)); // 바이러스 위치 정보 큐에 삽입
            }
        }

        recursion(0, -1); // 백트래킹 하며 bfs 실행
        for (int i = 0; i < zero_sum.size(); i++)    result = Math.max(result, zero_sum.get(i));
        System.out.println(result);
    }

    static void recursion(int lev, int val) {
        if (lev == 3) {
            // 연구소로 그래프 초기화
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    graph[i][j] = room[i][j];
                }
            }
            // 벽을 3개 다 설치 할 수 있는 경우 bfs 실행
            int cnt = 0;
            for (int i = 0; i < 3; i++) {
                int x = positionCombination[i] % M;
                int y = positionCombination[i] / M;
                if (graph[y][x] == 0) {
                    graph[y][x] = 1;
                    cnt++;
                }
            }
            if (cnt == 3) bfs();
            return;
        }
        for (int i = 0; i < N * M; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (val < i) {
                    positionCombination[lev] = i;
                    recursion(lev + 1, i);
                }
                visited[i] = false;
            }
        }
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>(start_q);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int new_x = x + dir_x[i];
                int new_y = y + dir_y[i];
                if (new_x < 0 || new_y < 0 || new_x >= M || new_y >= N) continue;
                if (graph[new_y][new_x] == 0) {
                    graph[new_y][new_x] = 2;
                    q.offer(new Pair(new_x, new_y));
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) cnt++;
            }
        }
        zero_sum.add(cnt);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}