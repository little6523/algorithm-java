import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer con = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(con.nextToken());
        int c = Integer.parseInt(con.nextToken());

        char[][] arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        System.out.print(main.solution(r, c, arr));
    }

    public String solution(int n, int m, char[][] arr) {
        Queue<int[]> q = new LinkedList<>();
        int[][] distance = new int[n][m];

        int[] jh = new int[2];
//지훈이 위치
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'J') {
                    jh[0] = i;
                    jh[1] = j;
                    distance[i][j] = 0;
                }//찾으면 배열에 담구여
                else if (arr[i][j] == 'F') {
                    q.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }//불위치 배열에 담아여 -> 큐로 바로 넣어여(불갯수 여러개 고려)
            }//n==r && m==c 입니다
        }
//네방향 좌표
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];//빼서 네방향 확인하는 for문
                int ny = tmp[1] + dy[i];//각 좌표값이 배열의 크기를 벗어나지 않았을때. // 길 (.)이면 , 방문하지않았으면
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == '.' && distance[nx][ny] == -1) {
                    q.offer(new int[]{nx, ny}); //그 좌표값을 큐에 넣어요
                    distance[nx][ny] = distance[tmp[0]][tmp[1]] + 1; //그리고 현재 거리값 +1;
                }
            }
        }
//저건 제일 처음인데 오탈자떄문에 틀린줄 몰라서 새로짰거든여
        //이거는 그냥 불이랑 지훈이 그 차이를
        //Integer.MIN_VALUE; <- 이걸로 뒀었어여 불 초기값을 그냥 젤 작은값으로 하면
        //똑같이 큐에서 돌려도 비교가되니까
        //근데 그냥 야매임
        q.offer(jh);
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            //배열의 끝에 도달했다는거는 0, n-1 , 0, m
            if (tmp[0] == 0 || tmp[0] == n - 1 || tmp[1] == 0 || tmp[1] == m - 1) {
                //그때 min에 값을 넣어줘여
                min = Math.min(min, distance[tmp[0]][tmp[1]] + 1);
            } 
            //distance는 재초기화안하고
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == '.') {
                    //이동할 위치의 거리가 현재거리+1 한것보다 같거나 작으면 불이 더 빨리 도달했다는 뜻이니까 갈 수 없는 곳
                    //아니면 불이 아직 도달하지 않았을때
                    if (distance[nx][ny] > distance[tmp[0]][tmp[1]] + 1 || distance[nx][ny] == -1 ) {
                        q.offer(new int[]{nx, ny});
                        distance[nx][ny] = distance[tmp[0]][tmp[1]] + 1;
                    }
                }
            }
        }


        return min == Integer.MAX_VALUE ? "IMPOSSIBLE" : min + "";
    }
}
